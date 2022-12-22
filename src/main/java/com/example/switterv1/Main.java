package com.example.switterv1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class Main {

    @GetMapping
    public String greeting(Map<String, Object> model) {

        return "home";
    }
}
