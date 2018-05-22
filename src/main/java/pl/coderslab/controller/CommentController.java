package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.service.CommentService;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @GetMapping("/add/{id}")
    public String add(Model model){
        model.addAttribute("comment", new Comment());
        return "newcomment" ;
    }

    @PostMapping("/add/{tweetId}")
    public String save(@PathVariable Long tweetId, @Valid @ModelAttribute Comment comment, BindingResult bindingResult, HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        if (bindingResult.hasErrors()){
            return "newcomment";
        }
        comment.setCreated(LocalDateTime.now());
        comment.setUser(userService.findUserById(userId));
        Tweet tweet = tweetService.findOneTweetById(tweetId);
        comment.setTweet(tweet);
        commentService.saveComment(comment);

        return "redirect:/tweet/details/"+ tweet.getId();
    }

    @GetMapping("/all/{id}")
    public String show(@PathVariable Long id, @ModelAttribute Tweet tweet){

        return "tweets" ;
    }

}
