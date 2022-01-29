package com.example.eregistrar.controller;

import com.example.eregistrar.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value={ "/eregistrar/student/home"})
    public String home(Model model){
        return "home/index";
    }

}
