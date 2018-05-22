package pl.coderslab.entity;


import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.LoginUserValidator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tweets")
public class Tweet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(groups = {Default.class,LoginUserValidator.class})
    @Size(min=5, max=50)
    private String title;

    @NotEmpty(groups = {Default.class,LoginUserValidator.class})
    @Size(max=160)
    private String text;

    private LocalDateTime created;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Tweet(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
