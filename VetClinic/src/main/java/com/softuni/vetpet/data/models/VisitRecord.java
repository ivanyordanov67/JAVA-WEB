package com.softuni.vetpet.data.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "visit_records")
public class VisitRecord extends BaseEntity{

    private Pet pet;
    private String diagnose;
    private String medicine;
    private List<Appointment> appointments;

    public VisitRecord() {
    }

    @Column
    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    @Column
    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @OneToMany(mappedBy = "record", cascade = {CascadeType.ALL})
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
