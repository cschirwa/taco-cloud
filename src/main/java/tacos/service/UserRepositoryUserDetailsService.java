package tacos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.User;
import tacos.repository.UserRepository;

@Service
@Slf4j
public class UserRepositoryUserDetailsService implements UserDetailsService{

	private UserRepository userRepository;
	
	@Autowired
	public UserRepositoryUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isPresent()) {
			log.info("User {} found. (Id: {})", username, user.get().getFullname() );
			return user.get();
		} 
		throw new UsernameNotFoundException("User " + username + " does not exist");
	}

}
