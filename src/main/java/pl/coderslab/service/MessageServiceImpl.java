package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;
import pl.coderslab.repository.MessageRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAllBySender(User sender) {
        return messageRepository.findAllBySender(sender);
    }

    @Override
    public List<Message> findAllByReceiver(User receiver) {
        return messageRepository.findAllByReceiver(receiver);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> findAllMessagesByReceiverAndSender(Long id) {
        return messageRepository.findAllByReceiverAndSenderId(id);
    }
}
