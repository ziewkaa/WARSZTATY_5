package pl.coderslab.service;

import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;

import java.util.List;

public interface MessageService {

    Message findById(Long id);

    List<Message> findAllBySender(User sender);

    List<Message> findAllByReceiver(User receiver);

    void saveMessage(Message message);

    List<Message> findAllMessagesByReceiverAndSender(Long id);

    void deleteMessageById(Long id);
}
