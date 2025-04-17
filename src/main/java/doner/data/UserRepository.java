package doner.data;
import org.springframework.data.repository.CrudRepository;

import doner.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}