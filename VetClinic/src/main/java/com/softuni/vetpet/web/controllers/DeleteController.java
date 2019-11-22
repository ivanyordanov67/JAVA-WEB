package com.softuni.vetpet.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeleteController {

    @GetMapping("/delete")
    public void removePet(HttpServletRequest request){
       String id = request.getParameter("id");
        System.out.println();
    }
}
