package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.LoginUserValidator;

import javax.persistence.*;
import javax.validation.groups.Default;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    @NotEmpty(groups = {LoginUserValidator.class, Default.class})
    private String content;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    private boolean read = false;

    public Message(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
