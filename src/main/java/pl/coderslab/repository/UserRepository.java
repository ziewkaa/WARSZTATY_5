package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u  WHERE u.id = :id")
    User findById(@Param("id") Long id);

    @Query("SELECT u FROM User u  WHERE u.email = :email")
    User findByEmail(@Param("email") String email );

    @Query("UPDATE User u SET u = :user")
    User findByEmail(@Param("user") User user);

//    @Query("UPDATE User u SET u.password = :password, u.email = :email, u.firstName = :firstName, u.lastName = :lastName WHERE u.id = id")
//    void updateUserById(@Param("password") String password, @Param("email") String email,@Param("firstName")  String firstName, @Param("lastName") String lastName,@Param("id") Long id);

}
