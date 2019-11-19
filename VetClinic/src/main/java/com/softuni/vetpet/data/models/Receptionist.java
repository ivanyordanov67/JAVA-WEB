package com.softuni.vetpet.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Receptionist extends BaseEntity{

    private List<Appointment> appointments;

    public Receptionist() {
    }

    @OneToMany(mappedBy = "receptionist", cascade = {CascadeType.ALL})
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
