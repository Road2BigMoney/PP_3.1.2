package ru.kata.katalessons.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.katalessons.web.models.User;
import ru.kata.katalessons.web.services.UserService;


import java.sql.SQLException;

@Controller

public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("users", userService.listUsers());
        return "pages/index";
    }

    @GetMapping("/new")
    public String saveForm(@ModelAttribute("user") User user) throws SQLException {


        return "pages/save";
    }


    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user) throws SQLException {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String userInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "pages/user-info";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "pages/edit";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}
