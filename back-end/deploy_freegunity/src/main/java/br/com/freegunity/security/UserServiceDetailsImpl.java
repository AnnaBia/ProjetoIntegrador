package br.com.freegunity.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.freegunity.model.User;
import br.com.freegunity.repository.UserRepository;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> usuario = userRepository.findByUsernameIgnoreCase(username);
		usuario.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

		return usuario.map(UserDetailsImpl::new).get();
	}

}
