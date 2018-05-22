package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query("SELECT m FROM Message m WHERE m.id = :id")
    Message findById(@Param("id") Long id);

    @Query("SELECT m FROM Message m WHERE m.sender = :sender")
    List<Message> findAllBySender(@Param("sender") User sender);

    @Query("SELECT m FROM Message m WHERE m.receiver = :receiver")
    List<Message> findAllByReceiver(@Param("receiver") User receiver);

    @Query("SELECT m FROM Message m WHERE m.receiver.id = :id AND m.sender.id = :id")
    List<Message> findAllByReceiverAndSenderId(@Param("id") Long id);
}
