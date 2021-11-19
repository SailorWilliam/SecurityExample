package ru.sakhnenko.spring.another.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sakhnenko.spring.another.entity.Role;
import ru.sakhnenko.spring.another.entity.User;
import ru.sakhnenko.spring.another.repository.RoleRepository;
import ru.sakhnenko.spring.another.repository.UserRepository;
import ru.sakhnenko.spring.another.service.RoleService;
import ru.sakhnenko.spring.another.service.UserService;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getRolesNames());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {
        user.setUsername(username);

        List<String> roles = roleService.getRolesNames();

        user.getRoles().clear();

        for(String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(roleRepository.findByName(key));
            }
        }
        userRepository.save(user);
        return "redirect:/user";
    }
}
