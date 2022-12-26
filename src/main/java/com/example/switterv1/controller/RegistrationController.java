package com.example.switterv1.controller;

import com.example.switterv1.domain.User;
import com.example.switterv1.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RegistrationController {

    private final UserSevice userSevice;

    public RegistrationController(UserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {

        return new ModelAndView("registration");
    }

    @PostMapping("/registration")
    public ModelAndView addUser(User user, Map<String, Object> model) {

        if (!userSevice.addUser(user)) {
            model.put("message", "Пользователь  таким именем существует!");
            return new ModelAndView("registration");
        }

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/activate/{code}")
    public ModelAndView activate(Model model, @PathVariable String code) {
        boolean isActivated = userSevice.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Shit try one more time");
        }

        return new ModelAndView("login");
    }
}
