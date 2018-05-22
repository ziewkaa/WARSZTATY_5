package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.CommentService;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.LoginUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @Autowired
    CommentService commentService;

    @GetMapping("/home")
    public String showHomepage(HttpSession session, Model model){

        Long id =  (Long) session.getAttribute("userId");

        if (id == null){
            return "redirect:/login";
        }

        List<Tweet> tweets = tweetService.findAllTweets();
        model.addAttribute("tweets",tweets);
        return "homeuser";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session){

        Long id = (Long) session.getAttribute("userId");

        if(id == null) {
            model.addAttribute("user", new User());
            return "newuser";
        }

        return "redirect:/user/home" ;

    }

    @PostMapping("/add")
    public String edit(@Validated({LoginUserValidator.class}) @ModelAttribute User user, BindingResult bindingResult, HttpSession session){

        String email = user.getEmail();

        if (bindingResult.hasErrors()){
            return "newuser";
        }

        if (userService.findUserByEmail(email) == null) {
            userService.saveUser(user);
            Long id = user.getId();
            session.setAttribute("userId", id);
            return "redirect:/user/home" ;
        }
        return "newuser" ;
    }

    @GetMapping("/edit")
    public String edit(Model model, HttpSession session){

        Long id =  (Long) session.getAttribute("userId");

        if (id == null){
            return "redirect:/login";
        }
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "useredit" ;
    }

    @PostMapping("/edit")
    public String saveEdit(@Validated({LoginUserValidator.class}) @ModelAttribute User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "useredit";
        }
        userService.saveUser(user);
        return "redirect:/user/home" ;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request){

        request.setAttribute("id", id);
        return "deleteuser" ;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @RequestParam boolean confirm, HttpSession session){

        if (confirm) {
            userService.deleteUserById(id);
            session.removeAttribute("userId");
            return "redirect:/";
        }

        return "redirect:/user/home" ;
    }

    @GetMapping("/tweets")
    public String tweets(Model model, HttpSession session){

        Long id =  (Long) session.getAttribute("userId");

        if (id == null){
            return "redirect:/login";
        }
        List<Tweet> tweets = tweetService.findAllTweetsByUserID(id);
        model.addAttribute("tweets", tweets);
        return "usertweets" ;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model, HttpSession session){

        Long userId =  (Long) session.getAttribute("userId");

        if (userId == null){
            return "redirect:/login";
        }

        User user = userService.findUserById(id);
        List<Tweet> tweets = tweetService.findAllTweetsByUserID(id);
        model.addAttribute("tweets", tweets);
        model.addAttribute(user);
        return "userdetails" ;
    }


}
