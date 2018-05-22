package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.service.CommentService;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.LoginUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("tweet", new Tweet());
        return "newtweet" ;
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Tweet tweet, BindingResult bindingResult, HttpSession session){

        Long id = (Long) session.getAttribute("userId");

        if (bindingResult.hasErrors()){
            return "newtweet";
        }

        tweet.setUser(userService.findUserById(id));
        tweet.setCreated(LocalDateTime.now());
        tweetService.saveTweet(tweet);
        return "redirect:/user/home" ;
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){

        Tweet tweet = tweetService.findOneTweetById(id);
        model.addAttribute("tweet",tweet);
        return "tweetedit" ;
    }

    @PostMapping("/edit/{id}")
    public String saveEdit(@Valid @ModelAttribute Tweet tweet, BindingResult bindingResult, HttpSession session){

        if (bindingResult.hasErrors()){
            return "tweetedit";
        }
        tweet.setUser(userService.findUserById((Long) session.getAttribute("userId")));
        tweet.setCreated(LocalDateTime.now());
        tweetService.saveTweet(tweet);
        return "redirect:/user/home" ;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model, HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        List<Comment> comments = commentService.findAllCommentsByTweetId(id);
        Tweet tweet = tweetService.findOneTweetById(id);
        model.addAttribute("comments", comments);
        model.addAttribute("tweet", tweet);
        return "tweetdetails" ;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request){

        request.setAttribute("id", id);
        return "deletetweet" ;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @RequestParam String confirm) {

        if (confirm.equals("yes")) {
            tweetService.deleteTweet(tweetService.findOneTweetById(id));
            return "redirect:/user/home";
        }

        return "redirect:/user/home" ;
    }


    @GetMapping("/all/{id}")
    public String show(@PathVariable Long id, @ModelAttribute Tweet tweet){
        tweetService.findAllTweetsByUserID(id);
        return "tweets" ;
    }

}
