package com.softuni.demo1.web.controllers;


import com.softuni.demo1.servises.BeersService;
import com.softuni.demo1.web.models.BeerViewModel;
import com.softuni.demo1.web.models.CreateBeerViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BeersController {

    private final BeersService beersService;
    private final ModelMapper modelMapper;

    public BeersController(BeersService beersService, ModelMapper modelMapper) {
        this.beersService = beersService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView getAllBeers(ModelAndView modelAndView){
        List<BeerViewModel> beers = beersService.getBeers()
                .stream()
                .map(b->this.modelMapper.map(b, BeerViewModel.class))
                .collect(Collectors.toList());
        modelAndView.addObject("beers", beers);
        modelAndView.addObject("text", "Hello ModelAndView!");
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

   // @GetMapping("/{beerName}")
    public ModelAndView getBeersDetails(@PathVariable("beerName") String beerName, ModelAndView modelAndView){
        modelAndView.addObject("beers", beerName);
        modelAndView.setViewName("details.html");
        return modelAndView;
    }

   @PostMapping
    public String createBeer(@ModelAttribute CreateBeerViewModel model){

        beersService.createBeer(model.getName());

        return "redirect:/";
    }
}
