package doner.data;

import java.util.Optional;
import java.util.UUID;

import doner.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import doner.DonerOrder;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<DonerOrder, Long> {
    Page<DonerOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
