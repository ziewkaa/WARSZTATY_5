package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Long> {

    @Query("SELECT t FROM Tweet t JOIN t.user u WHERE u.id = :userId")
    List<Tweet> findAllByUserID(@Param("userId") Long userId);

    List<Tweet> findAllByUser(User user);

    @Query("SELECT t FROM Tweet t ORDER BY t.created DESC")
    List<Tweet> findAllByOrderByCreatedDesc();

    @Query("DELETE FROM Tweet t WHERE t.user.id = :userId")
    void deleteAllByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Tweet t WHERE t.id = :id")
    Tweet findOneById(@Param("id") Long id);

}