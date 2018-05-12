package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findById(@Param("userId") Long userId);
    User findByEmail(@Param("userEmail") String email );
}
