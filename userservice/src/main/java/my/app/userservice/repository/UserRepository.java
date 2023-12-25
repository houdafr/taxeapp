package my.app.userservice.repository;

import my.app.userservice.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCin(String cin);
}

