package com.softuni.vetpet.service.models;

import com.softuni.vetpet.data.models.Animal;
import com.softuni.vetpet.data.models.Gender;
import com.softuni.vetpet.data.models.User;

public class PetServiceModel {

    private String id;
    private String petName;
    private String animalType;
    private String gender;
    private int years;
    private User owner;

    public PetServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
