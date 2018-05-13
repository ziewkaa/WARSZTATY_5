package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/newtweet")
    public String add(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "newtweet" ;
    }

    @PostMapping("/newtweet")
    public String save(@Valid @ModelAttribute Tweet tweet, BindingResult bindingResult, HttpServletRequest request){

        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        User user =  userRepository.findById(userId);

        if (bindingResult.hasErrors()){
            return "newtweet";
        }
        tweet.setUser(user);
        tweet.setCreated(LocalDateTime.now());
        tweetRepository.save(tweet);
        return "redirect/:userpage" ;
    }


}
