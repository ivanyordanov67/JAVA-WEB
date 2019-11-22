package com.softuni.vetpet.data.repositories;

import com.softuni.vetpet.data.models.Pet;
import com.softuni.vetpet.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, String> {

    @Modifying
    @Query("update Pet p set p.owner = ?1")
    void update(Pet pet);

    List<Pet> getAllByOwner(User user);

    Pet getPetById(String id);

}
