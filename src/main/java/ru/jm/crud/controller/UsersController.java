package ru.jm.crud.controller;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.jm.crud.model.User;
import ru.jm.crud.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUser(ModelMap modelMap) {
        List<User> list = userService.getAllUsers();
        modelMap.addAttribute("list", list);
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/new")
    public String newUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(@PathVariable("id") long id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect:/user/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/user/";
    }
}
