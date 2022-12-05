package com.nest.studentappnew_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

    @GetMapping("/")

    public String Homepage(){
        return "Welcome to my website";
    }
    @GetMapping("/contact")
    public String Contactpage(){
        return "welcome to my contactpage";
    }
    @GetMapping("/gallery")
    public String Gallerypage(){
        return "welcome to my gallery";
    }
    @GetMapping("/home")
    public String Home(){
        return "welcome to my homepage";
    }
}
