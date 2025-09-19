package doner.data;

import doner.Doner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DonerRepository extends JpaRepository<Doner, Long> {
}
