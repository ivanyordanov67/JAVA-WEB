package com.softuni.vetpet.web.controllers;

import com.softuni.vetpet.data.models.Pet;
import com.softuni.vetpet.service.models.PetServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;
import com.softuni.vetpet.service.services.PetService;
import com.softuni.vetpet.service.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("/profile")
public class UserProfileController {

    private final UserService userService;
    private final PetService petService;

    public UserProfileController(UserService userService, PetService petService) {
        this.userService = userService;
        this.petService = petService;
    }

    @GetMapping("/profile")
    public ModelAndView getProfile(ModelAndView model, HttpSession session) {
        String username = session.getAttribute("username").toString();
        UserServiceModel userServiceModel = this.userService.getUserByUsername(username);
        List<PetServiceModel> pets = this.petService.getAllByOwner(userServiceModel);
        model.addObject("pets", pets);
        model.setViewName("user/profile.html");

        return model;
    }
}
