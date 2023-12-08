package proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}