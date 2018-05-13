package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/")
    public String publicHomepage(Model model){
        List<Tweet> tweets = tweetRepository.findAllOrderByCreatedDesc();
        model.addAttribute("tweets", tweets);
        return "homepage";
    }

    @GetMapping("/home")
    public String userHomepage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        List<Tweet> tweets = tweetRepository.findAllByUserID(userId);
        model.addAttribute("tweets", tweets);
        return "userhomepage";
    }

    @GetMapping("/usertweets/{id}")
    public String userTweets(@PathVariable Long id, Model model){
        List<Tweet> tweets = tweetRepository.findAllByUserID(id);
        model.addAttribute("tweets", tweets);
        return "usertweets";
    }
}