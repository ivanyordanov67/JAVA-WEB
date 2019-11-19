package com.softuni.vetpet.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
   public String getIndex(){
       return "home/index.html";
   }

    @GetMapping("/home")
    public String getHome(){
        return "home/home.html";
    }
}
