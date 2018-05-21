package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.validator.LoginUserValidator;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.groups.Default;
import java.util.List;

@Entity
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(groups = {LoginUserValidator.class})
    private String firstName;

    @NotEmpty(groups = {LoginUserValidator.class})
    private String lastName;

    @NotEmpty(groups = {Default.class,LoginUserValidator.class})
    private String password;

    @Email(groups = {Default.class, LoginUserValidator.class })
    @Column(unique = true)
    private String email;

    @OneToMany
    private List<Tweet> tweets;

    @OneToMany
    private List<Comment> comments;

    public User (){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
