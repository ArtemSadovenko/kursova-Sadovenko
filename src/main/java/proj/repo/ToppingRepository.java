package proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proj.entity.Topping;

public interface ToppingRepository extends JpaRepository<Topping, Long> {

}