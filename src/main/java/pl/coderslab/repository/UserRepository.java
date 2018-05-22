package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.User;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u  WHERE u.id = :id")
    User findById(@Param("id") Long id);

    @Query("SELECT u FROM User u  WHERE u.email = :email")
    User findByEmail(@Param("email") String email );

    @Query("DELETE FROM User u WHERE u.id = :id")
    void deleteUserById(@Param("id") Long id);

}
