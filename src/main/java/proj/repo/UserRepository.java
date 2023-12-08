package proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}