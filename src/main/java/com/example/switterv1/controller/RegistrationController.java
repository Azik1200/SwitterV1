package com.example.switterv1.controller;

import com.example.switterv1.domain.User;
import com.example.switterv1.service.UserSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public ModelAndView addUser(
            @RequestParam("password2") String passwordConfirm,
            @Valid User user,
            BindingResult bindingResult,
            Model model) {
        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfirm);

        if (isConfirmEmpty) {
            model.addAttribute("password2Error", "Потверждение пароля, не может быть пустым!");
        }

        if (user.getPassword() != null && user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("passwordError", "Пароли не совпадают!");
        }

        if (isConfirmEmpty || bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return new ModelAndView("registration");
        }

        if (!userSevice.addUser(user)) {
            model.addAttribute("usernameError", "Пользователь  таким именем существует!");

            return new ModelAndView("registration");
        }

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/activate/{code}")
    public ModelAndView activate(Model model, @PathVariable String code) {
        boolean isActivated = userSevice.activateUser(code);

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "Пользователь активирован");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Код не найден");
        }

        return new ModelAndView("login");
    }
}
