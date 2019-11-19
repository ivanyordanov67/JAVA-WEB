package com.softuni.demo1.servises.implementation;


import com.softuni.demo1.data.models.entities.Beer;
import com.softuni.demo1.data.models.service.BeerServiceModel;
import com.softuni.demo1.data.repositories.BeerRepository;
import com.softuni.demo1.servises.BeersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeersServiceImpl implements BeersService {

    private final BeerRepository beerRepository;
    private final ModelMapper modelMapper;

    public BeersServiceImpl(BeerRepository beerRepository, ModelMapper modelMapper) {
        this.beerRepository = beerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BeerServiceModel> getBeers() {
        return this.beerRepository.findAll()
                .stream()
                .map(b->this.modelMapper.map(b, BeerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createBeer(String name) {
      Beer beer = new Beer();
      beer.setName(name);
      beerRepository.saveAndFlush(beer);
    }
}
