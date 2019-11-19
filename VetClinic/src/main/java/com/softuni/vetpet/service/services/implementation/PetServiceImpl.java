package com.softuni.vetpet.service.services.implementation;

import com.softuni.vetpet.data.models.Animal;
import com.softuni.vetpet.data.models.Gender;
import com.softuni.vetpet.data.models.Pet;
import com.softuni.vetpet.data.repositories.PetRepository;
import com.softuni.vetpet.service.models.PetServiceModel;
import com.softuni.vetpet.service.services.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, ModelMapper modelMapper) {
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPet(PetServiceModel petServiceModel) {
        Pet pet = modelMapper.map(petServiceModel, Pet.class);
        pet.setAnimalType(Animal.valueOf(petServiceModel.getAnimalType()));
        pet.setGender(Gender.valueOf(petServiceModel.getGender()));
        this.petRepository.save(pet);
    }

    @Override
    public void update(Pet pet) {
this.petRepository.update(pet);
    }
}
