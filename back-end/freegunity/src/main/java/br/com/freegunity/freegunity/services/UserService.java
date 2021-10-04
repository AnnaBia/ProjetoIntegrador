package br.com.freegunity.freegunity.services;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.freegunity.freegunity.model.UserLogin;
import br.com.freegunity.freegunity.model.Usuario;
import br.com.freegunity.freegunity.repository.UsuarioRepository;

@Service
public class UserService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> listarUsuarios() {
		return repository.findAll();

	}

	public Optional<UserLogin> Entrar(Optional<UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuarioIgnoreCase(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setId(usuario.get().getId());
				user.get().setNome(usuario.get().getNome());
				user.get().setUsuario(usuario.get().getUsuario());
				user.get().setEmail(usuario.get().getEmail());
				user.get().setAdmin(usuario.get().getAdmin());

				return user;
			}
		}
		return null;
	}

	public Optional<Usuario> Cadastrar(Usuario usuario) {
		Optional<Usuario> user = repository.findByUsuarioIgnoreCase(usuario.getUsuario());

		if (user.isPresent()) {
			return Optional.ofNullable(null);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return Optional.of(repository.save(usuario));
	}

	public Optional<Usuario> Atualizar(Usuario usuario) {
		if (repository.findById(usuario.getId()).isPresent()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);

			return Optional.of(repository.save(usuario));

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
		}
	}
}
