package doner.data;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import doner.DonerOrder;

public interface OrderRepository extends CrudRepository<DonerOrder, Long> {}
