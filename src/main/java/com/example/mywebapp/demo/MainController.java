package com.example.mywebapp.demo;

import com.example.mywebapp.demo.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage(){
        return "inndex";
    }
    }

