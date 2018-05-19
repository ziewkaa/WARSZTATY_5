package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.LoginUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @GetMapping("/")
    public String showHomepage(HttpSession session, Model model){

        Long id =  (Long) session.getAttribute("userId");

        if (id == null){
            return "redirect:/login";
        }

        User user = userService.findUserById((Long) session.getAttribute("userId"));
        List<Tweet> tweets = tweetService.findAllTweetsByUserID(user.getId());
        model.addAttribute(tweets);
        return "homeuser";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "newuser" ;
    }

    @PostMapping("/add")
    public String save(@Validated({LoginUserValidator.class}) @ModelAttribute User user, BindingResult bindingResult,HttpSession session, HttpServletRequest request){
        session = request.getSession();
        String email = user.getEmail();

        if (bindingResult.hasErrors()){
            return "newuser";
        }

        if (userService.findUserByEmail(email) == null) {
            userService.saveUser(user);
            Long id = user.getId();
            session.setAttribute("userId", id);
            return "redirect:/" ;
        }
        return "newuser" ;
    }
}
