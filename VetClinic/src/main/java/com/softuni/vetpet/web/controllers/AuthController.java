package com.softuni.vetpet.web.controllers;

import com.softuni.vetpet.data.models.Role;
import com.softuni.vetpet.service.models.LoginServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;
import com.softuni.vetpet.service.services.HashPasswordService;
import com.softuni.vetpet.service.services.UserService;
import com.softuni.vetpet.service.services.ValidationService;
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
    private final ValidationService validationService;

    @Autowired
    public AuthController(UserService userService, HashPasswordService hashService, ModelMapper modelMapper, ValidationService validationService) {
        this.userService = userService;
        this.hashService = hashService;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    @GetMapping("/register")
    public String register(){
      return "auth/register.html";

    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute UserServiceModel model){

        if (!this.validationService.isValid(model.getPassword(), model.getConfirmPassword())){
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
    public String loginConfirm(@ModelAttribute LoginServiceModel model, HttpSession session){

        if (!userService.existUser(model)){
            return("redirect:/auth/login");
        }

        session.setAttribute("username", model.getUsername());



        return("redirect:/home");
}


}
