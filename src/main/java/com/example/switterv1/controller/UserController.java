package com.example.switterv1.controller;

import com.example.switterv1.domain.Role;
import com.example.switterv1.domain.User;
import com.example.switterv1.service.UserSevice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserSevice userSevice;

    public UserController(UserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public ModelAndView userList(Model model) {
        model.addAttribute("users", userSevice.findAll());
        return new ModelAndView("userList");
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("{user}")
    public ModelAndView userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return new ModelAndView("userEdit");
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ModelAndView userSave(@RequestParam("userID") User user,
                                 @RequestParam Map<String, String> form,
                                 @RequestParam String username) {
        userSevice.saveUser(user, username, form);

        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/profile")
    public ModelAndView getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return new ModelAndView("profile");
    }

    @PostMapping("/profile")
    public ModelAndView updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email) {
        userSevice.updateProfile(user, password, email);

        return new ModelAndView("redirect:/user/profile");
    }

    @GetMapping("subscribe/{user}")
    public ModelAndView subscribe(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
    ) {
        userSevice.subscribe(currentUser, user);

        return new ModelAndView("redirect:/user-messages/" + user.getId());
    }

    @GetMapping("unsubscribe/{user}")
    public ModelAndView unsubscribe(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
    ) {
        userSevice.unsubscribe(currentUser, user);

        return new ModelAndView("redirect:/user-messages/" + user.getId());
    }

    @GetMapping("{type}/{user}/list")
    public ModelAndView userList(
            @PathVariable User user,
            @PathVariable String type,
            Model model
    ) {
        model.addAttribute("userChannel", user);
        model.addAttribute("type", type);

        if ("subscriptions".equals(type)) {
            model.addAttribute("users" , user.getSubscription());
        } else {
            model.addAttribute("users", user.getSubscribers());
        }

        return new ModelAndView("subscriptions");
    }
}
