package com.softuni.vetpet.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    private String petName;
    private Animal animalType;
    private Gender gender;
    private int years;
    private User owner;
    private Doctor doctor;
    private HealthCard healthCard;
    private List<VisitRecord> records;


    public Pet() {
    }

    @Column(name = "pet_name", nullable = false)
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "animal_type", nullable = false)
    public Animal getAnimalType() {
        return animalType;
    }

    public void setAnimalType(Animal animalType) {
        this.animalType = animalType;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name = "years", nullable = false)
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @OneToOne(targetEntity = HealthCard.class)
    @JoinColumn(name = "health_card_id", referencedColumnName = "id")
    public HealthCard getHealthCard() {
        return healthCard;
    }

    public void setHealthCard(HealthCard healthCard) {
        this.healthCard = healthCard;
    }

    @OneToMany(mappedBy = "pet", cascade = {CascadeType.ALL})
    public List<VisitRecord> getRecords() {
        return records;
    }

    public void setRecords(List<VisitRecord> records) {
        this.records = records;
    }
}
