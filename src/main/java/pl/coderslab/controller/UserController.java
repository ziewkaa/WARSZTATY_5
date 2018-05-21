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

    @GetMapping("/home")
    public String showHomepage(HttpSession session, Model model){

        Long id =  (Long) session.getAttribute("userId");

        if (id == null){
            return "redirect:/login";
        }

        List<Tweet> tweets = tweetService.findAllTweetsByUserID(id);
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
        model.addAttribute(user);
        return "useredit" ;
    }

    @PostMapping("/edit")
    public String saveEdit(@Validated({LoginUserValidator.class}) @ModelAttribute User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "newuser";
        }

//        Long id = user.getId();
//        String password = user.getPassword();
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
//        String email = user.getEmail();
//        userService.updateUserById(id,password,lastName,firstName,email);
        userService.saveUser(user);
        return "redirect:/user/home" ;
    }

}
