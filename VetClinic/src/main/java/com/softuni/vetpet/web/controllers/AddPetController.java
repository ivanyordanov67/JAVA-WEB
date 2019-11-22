package com.softuni.vetpet.web.controllers;

import com.softuni.vetpet.data.models.Pet;
import com.softuni.vetpet.data.models.User;
import com.softuni.vetpet.service.models.PetServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;
import com.softuni.vetpet.service.services.PetService;
import com.softuni.vetpet.service.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AddPetController {

    private final PetService petService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public AddPetController(PetService petService, UserService userService, ModelMapper modelMapper) {
        this.petService = petService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String getAddPet() {
        return "/pet/add-pet.html";
    }

    @PostMapping("/add")
    public ModelAndView addPet(@ModelAttribute PetServiceModel model, HttpSession session) {

        String username = session.getAttribute("username").toString();
        User owner = this.modelMapper.map(this.userService.getUserByUsername(username), User.class);
        //Pet pet = this.modelMapper.map(model, Pet.class);

       // owner.getPets().add(pet);
       model.setOwner(owner);

        this.petService.addPet(model);

        //this.petService.update(pet);


        return new ModelAndView("redirect:/profile");

    }
}
