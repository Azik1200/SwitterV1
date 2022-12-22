package com.example.switterv1;

import com.example.switterv1.domain.Message;
import com.example.switterv1.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Main {

    @Autowired
    private MessageRepo messageRepo;
    @GetMapping
    public String greeting(Map<String, Object> model) {

        return "home";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }
}
