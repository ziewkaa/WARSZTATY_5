package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;
import pl.coderslab.service.MessageService;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;


    @GetMapping("/new/{receiverId}")
    public String add(@PathVariable Long receiverId, Model model, HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        if(userId == null) {
            return "redirect:/login";
        }

        model.addAttribute("receiver", userService.findUserById(receiverId));
        model.addAttribute("message", new Message());
        return "newmessage" ;

    }

    @PostMapping("/new/{receiverId}")
    public String save(@Valid @ModelAttribute Message message, BindingResult bindingResult, @ModelAttribute User receiver, HttpSession session){

        Long sender = (Long) session.getAttribute("userId");

        if (bindingResult.hasErrors()){
            return "newmessage";
        }
        message.setCreated(LocalDateTime.now());
        message.setReceiver(userService.findUserById(receiver.getId()));
        message.setSender(userService.findUserById(sender));
        messageService.saveMessage(message);
        return "redirect:/message/sent" ;
    }

    @GetMapping("/all")
    public String all(Model model, HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        if(userId == null) {
            return "redirect:/login";
        }

        List<Message> messages = messageService.findAllMessagesByReceiverAndSender(userId);
        model.addAttribute("messages", messages);
        return "usermessages" ;

    }

}
