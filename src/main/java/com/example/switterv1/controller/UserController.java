package com.example.switterv1.controller;

import com.example.switterv1.domain.Role;
import com.example.switterv1.domain.User;
import com.example.switterv1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public ModelAndView userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return new ModelAndView("userList");
    }

    @GetMapping("{user}")
    public ModelAndView userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return new ModelAndView("userEdit");
    }

    @PostMapping
    public ModelAndView userSave(@RequestParam("userID") User user,
                           @RequestParam Map<String, String> form,
                           @RequestParam String username) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);

        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/test")
    @ResponseBody
    public List<User> test (@RequestParam(name = "email") String email) {
        return userRepo.findUserCustom(email);
    }
}
