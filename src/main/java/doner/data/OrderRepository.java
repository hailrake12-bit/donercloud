package doner.data;

import java.util.Optional;
import java.util.UUID;

import doner.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import doner.DonerOrder;

public interface OrderRepository extends JpaRepository<DonerOrder, Long> {
    Page<DonerOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
