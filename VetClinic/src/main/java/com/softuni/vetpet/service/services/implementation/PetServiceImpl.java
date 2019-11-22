package com.softuni.vetpet.service.services.implementation;

import com.softuni.vetpet.data.models.Animal;
import com.softuni.vetpet.data.models.Gender;
import com.softuni.vetpet.data.models.Pet;
import com.softuni.vetpet.data.models.User;
import com.softuni.vetpet.data.repositories.PetRepository;
import com.softuni.vetpet.service.models.PetServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;
import com.softuni.vetpet.service.services.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public PetServiceModel getPetById(String id) {
        return this.modelMapper.map(this.petRepository.getPetById(id), PetServiceModel.class);
    }

    @Override
    public List<PetServiceModel> getAllByOwner(UserServiceModel userServiceModel) {
        List<Pet> pets = this.petRepository.getAllByOwner(this.modelMapper.map(userServiceModel, User.class));
        return pets.stream().map(p->this.modelMapper.map(p, PetServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public void update(Pet pet) {
this.petRepository.update(pet);
    }
}
