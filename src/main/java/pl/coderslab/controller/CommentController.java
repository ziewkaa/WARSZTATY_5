package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("tweet", new Tweet());
        return "newtweet" ;
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Tweet tweet, BindingResult bindingResult, HttpSession session){


        return "redirect:/user/home" ;
    }

    @GetMapping("/all/{id}")
    public String show(@PathVariable Long id, @ModelAttribute Tweet tweet){

        return "tweets" ;
    }

}
