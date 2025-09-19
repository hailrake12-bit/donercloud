package doner.data;
import org.springframework.data.repository.CrudRepository;

import doner.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}