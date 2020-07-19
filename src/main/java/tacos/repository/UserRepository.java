package tacos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tacos.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByUsername(String username);
//	Optional<User> loadUserByUsername(String username) throws UsernameNotFoundException;

}
