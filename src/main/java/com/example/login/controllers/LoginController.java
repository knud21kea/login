package com.example.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class LoginController
{
    // simulates the db
    private ArrayList<String> userNames = new ArrayList<>(Arrays.asList("", "a", "ab", "abc"));

    @GetMapping("/index")
    public String start(Model model)
    {
        model.addAttribute("userNames", userNames);
        return "index";
    }

    @PostMapping("/index")
    public String createLogin(WebRequest account, Model model)
    {
        String user = account.getParameter("userName");
        userNames.add(user);
        model.addAttribute("userNames", userNames);
        return "redirect:created";
    }

    @GetMapping("/created")
    public String accountCreated() {
        return "created";
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
