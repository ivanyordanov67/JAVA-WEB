package com.softuni.vetpet.service.services;

import com.softuni.vetpet.data.models.Pet;
import com.softuni.vetpet.service.models.PetServiceModel;

public interface PetService {

    void addPet(PetServiceModel petServiceModel);
    void update(Pet pet);
}
