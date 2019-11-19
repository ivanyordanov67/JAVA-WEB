package com.softuni.vetpet.web.controllers;

import com.softuni.vetpet.data.models.Role;
import com.softuni.vetpet.data.models.User;
import com.softuni.vetpet.service.models.LoginServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;
import com.softuni.vetpet.service.services.HashPasswordService;
import com.softuni.vetpet.service.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final HashPasswordService hashService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(UserService userService, HashPasswordService hashService, ModelMapper modelMapper) {
        this.userService = userService;
        this.hashService = hashService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(){
      return "auth/register.html";

    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute UserServiceModel model){

        if (!model.getPassword().equals(model.getConfirmPassword())){
            return new ModelAndView("redirect:/auth/register");
        }else {
            model.setRole(Role.valueOf("admin"));
            model.setPassword(hashService.hashPassword(model.getPassword()));
            this.userService.registerUser(model);
            return new ModelAndView("redirect:/auth/login");
        }

    }

    @GetMapping("/login")
    public String login(){
        return "auth/login.html";
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@ModelAttribute LoginServiceModel model, HttpSession session){

        if (!userService.existUser(model)){
            return new ModelAndView("redirect:/auth/login");
        }
        ModelAndView modelAndView = new ModelAndView("/home/home");

        session.setAttribute("username", model.getUsername());


        return modelAndView;
}


}
