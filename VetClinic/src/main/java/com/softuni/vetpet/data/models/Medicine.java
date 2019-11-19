package com.softuni.vetpet.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine extends BaseEntity{

    private String medicineName;
    private List<HealthCard> healthCards;

    public Medicine() {
    }

    @Column(name = "medicine_name")
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @ManyToMany(mappedBy = "medicine")
    public List<HealthCard> getHealthCards() {
        return healthCards;
    }

    public void setHealthCards(List<HealthCard> healthCards) {
        this.healthCards = healthCards;
    }
}
