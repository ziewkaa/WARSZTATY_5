package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @GetMapping("/")
    public String publicHomepage(Model model, HttpSession session) {

        Long id = (Long) session.getAttribute("userId");

        if(id != null) {
            return "redirect:/user/home";
        }

        List<Tweet> tweets = tweetService.findAllTweetsOrderByCreatedDesc();
        model.addAttribute("tweets",tweets);
        return "home";
    }
}