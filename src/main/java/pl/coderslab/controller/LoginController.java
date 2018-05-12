package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.validator.LoginUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "newuser" ;
    }

    @PostMapping("/add")
    public String save(@Validated({LoginUserValidator.class}) @ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request){
        HttpSession session = request.getSession();
        String email = user.getEmail();
        if (bindingResult.hasErrors()){
            return "newuser";
        }
        if (userRepository.findByEmail(email) == null) {
            userRepository.save(user);
            Long id = user.getId();
            session.setAttribute("userId", id);
            return "redirect:/" ;
        }
        return "newuser" ;
    }

    @GetMapping("/login")
    public String check(Model model){
        model.addAttribute("user", new User());
        return "login" ;
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute User user,BindingResult bindingResult, HttpServletRequest request){
        if (bindingResult.hasErrors()){
            return "login";
        }
        HttpSession session = request.getSession();
        String email = user.getEmail();
        String password = user.getPassword();
        User checkUser = userRepository.findByEmail(email);
        if (checkUser != null) {
            if (checkUser.getPassword().equals(password)){
                return "home";
            }
        }
        return "redirect:/login";
    }


}
