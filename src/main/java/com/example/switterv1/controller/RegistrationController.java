package com.example.switterv1.controller;

import com.example.switterv1.domain.User;
import com.example.switterv1.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserSevice userSevice;

    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        if (!userSevice.addUser(user)) {
            model.put("message", "Пользователь  таким именем существует!");
            return "registration";
        }

        return "redirect:/login";
    }
}
