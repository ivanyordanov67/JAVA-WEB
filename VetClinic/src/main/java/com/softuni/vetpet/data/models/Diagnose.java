package com.softuni.vetpet.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diagnose")
public class Diagnose extends BaseEntity{

    private String diagnoseName;
    private List<HealthCard> healthCards;

    public Diagnose() {
    }


    @Column(name = "diagnose_name")
    public String getDiagnoseName() {
        return diagnoseName;
    }

    public void setDiagnoseName(String diagnoseName) {
        this.diagnoseName = diagnoseName;
    }

    @ManyToMany(mappedBy = "diagnose")
    public List<HealthCard> getHealthCards() {
        return healthCards;
    }

    public void setHealthCards(List<HealthCard> healthCards) {
        this.healthCards = healthCards;
    }
}
