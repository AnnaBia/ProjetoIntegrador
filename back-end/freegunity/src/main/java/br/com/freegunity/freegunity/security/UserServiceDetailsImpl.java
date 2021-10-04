package br.com.freegunity.freegunity.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.freegunity.freegunity.model.Usuario;
import br.com.freegunity.freegunity.repository.UsuarioRepository;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> usuario = userRepository.findByUsuarioIgnoreCase(username);
		usuario.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

		return usuario.map(UserDetailsImpl::new).get();
	}

}