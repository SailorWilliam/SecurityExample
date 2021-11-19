package ru.sakhnenko.spring.another.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sakhnenko.spring.another.entity.User;
import ru.sakhnenko.spring.another.repository.RoleRepository;
import ru.sakhnenko.spring.another.repository.UserRepository;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            model.addAttribute("errorMessage", "User exist\n");
            return "registration";
        }
        user.setActive(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(roleRepository.findById(1)));
        userRepository.save(user);
        return "redirect:/login";
    }
}
