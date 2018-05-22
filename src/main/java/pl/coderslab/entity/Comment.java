package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.LoginUserValidator;

import javax.persistence.*;
import javax.validation.groups.Default;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tweet tweet;

    @ManyToOne
    private User user;

    private LocalDateTime created;

    @NotEmpty(groups = {LoginUserValidator.class, Default.class})
    private String text;

    public Comment(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
