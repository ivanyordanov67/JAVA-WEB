package com.softuni.vetpet.data.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "health_card")
public class HealthCard extends BaseEntity {

    private Pet pet;
    private List<Diagnose> diagnose;
    private List<Medicine> medicine;

    public HealthCard() {
    }

    @OneToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "health_card_diagnose",
            joinColumns = { @JoinColumn(name = "health_card_id") },
            inverseJoinColumns = { @JoinColumn(name = "diagnose_id") }
    )
    public List<Diagnose> getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(List<Diagnose> diagnose) {
        this.diagnose = diagnose;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "health_card_medicine",
            joinColumns = { @JoinColumn(name = "health_card_id") },
            inverseJoinColumns = { @JoinColumn(name = "medicine_id") }
    )
    public List<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(List<Medicine> medicine) {
        this.medicine = medicine;
    }
}
