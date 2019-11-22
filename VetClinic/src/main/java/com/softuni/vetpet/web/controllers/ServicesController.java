package com.softuni.vetpet.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {

    @GetMapping("/services")
    public String getServices(){

        return "/common/services.html";
    }
}
