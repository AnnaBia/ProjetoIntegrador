package br.com.freegunity.freegunity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.freegunity.freegunity.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuarioIgnoreCase(String usuario);

	public Optional<Usuario> findAllByUsuarioContainingIgnoreCase(String usuario);

	public Optional<Usuario> findAllByEmailContainingIgnoreCase(String email);
	
	public Optional<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
