package ru.sakhnenko.spring.another.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sakhnenko.spring.another.entity.Message;
import ru.sakhnenko.spring.another.entity.User;
import ru.sakhnenko.spring.another.repository.MessageRepository;

@Controller
public class MainController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       Model model) {
        Iterable<Message> messages;
        if (!filter.equals("")) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String addPost(@AuthenticationPrincipal User user,
                          @RequestParam String text, @RequestParam String tag,
                          Model model) {
        Message message = new Message(text, tag, user);

        messageRepository.save(message);

        model.addAttribute("messages", messageRepository.findAll());

        return "main";
    }
}
