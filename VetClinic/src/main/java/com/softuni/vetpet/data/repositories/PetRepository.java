package com.softuni.vetpet.data.repositories;

import com.softuni.vetpet.data.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PetRepository extends JpaRepository<Pet, String> {

    @Modifying
    @Query("update Pet p set p.owner = ?1")
    void update(Pet pet);

}
