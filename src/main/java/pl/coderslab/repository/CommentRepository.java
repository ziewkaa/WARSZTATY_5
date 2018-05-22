package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("SELECT c FROM Comment c WHERE tweet_id = :tweetId ORDER BY c.created ASC")
    List<Comment> findAllByTweetIdOderByCreatedAsc(@Param("tweetId") Long tweetId);

    int countAllByTweetId(@Param("id") Long id);

}
