package com.softuni.vetpet.service.services;

import com.softuni.vetpet.data.models.Pet;
import com.softuni.vetpet.service.models.PetServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;

import java.util.List;

public interface PetService {

    void addPet(PetServiceModel petServiceModel);
    PetServiceModel getPetById(String id);
    List<PetServiceModel> getAllByOwner(UserServiceModel userServiceModel);
    void update(Pet pet);
}
