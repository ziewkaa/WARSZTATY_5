package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;
import pl.coderslab.validator.LoginUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String check(Model model, HttpSession session){

        Long id =  (Long) session.getAttribute("userId");

        if (id == null){
            model.addAttribute("user", new User());
            return "login" ;
        }

        return "redirect:/user/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute User user,BindingResult bindingResult, HttpSession session){

        if (bindingResult.hasErrors()){
            return "login";
        }

        String email = user.getEmail();
        String password = user.getPassword();
        User checkUser = userService.findUserByEmail(email);

        if (checkUser != null) {
            if (checkUser.getPassword().equals(password)){
                session.setAttribute("userId", checkUser.getId());
                return "redirect: /user/home";
            }
        }

        return "login";
    }

    @GetMapping("/logout")
    public String signOut(Model model, HttpSession session){

        Long id =  (Long) session.getAttribute("userId");

        if (id == null){
            model.addAttribute("user", new User());
            return "login" ;
        }

        session.removeAttribute("userId");
        return "redirect:/";

    }


}
