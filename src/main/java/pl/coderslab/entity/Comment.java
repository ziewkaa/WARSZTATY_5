package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.LoginUserValidator;

import javax.persistence.*;
import javax.validation.groups.Default;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(mappedBy = "comments", fetch = FetchType.EAGER)
    private User user;

//    @ManyToOne(mappedBy = "comments", fetch = FetchType.EAGER)
    private Tweet tweet;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
