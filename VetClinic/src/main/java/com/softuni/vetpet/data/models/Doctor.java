package com.softuni.vetpet.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity{

    private String docName;
    private Role role;
    private List<Pet> patients;
    private List<Appointment> appointments;

    public Doctor() {
    }

    @Column(name = "doc_name", nullable = false, unique = true)
    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.ALL})
    public List<Pet> getPatients() {
        return patients;
    }

    public void setPatients(List<Pet> patients) {
        this.patients = patients;
    }

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.ALL})
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
