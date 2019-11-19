package com.softuni.demo1.servises;

import com.softuni.demo1.data.models.entities.Beer;
import com.softuni.demo1.data.models.service.BeerServiceModel;

import java.util.List;

public interface BeersService {

   List<BeerServiceModel> getBeers();

   void createBeer(String name);
}
