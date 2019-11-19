package com.softuni.vetpet.data.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity {

    private Doctor doctor;
    private Date appointment;
    private Receptionist receptionist;
    private VisitRecord record;

    public Appointment() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receptionist_id")
    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    public VisitRecord getRecord() {
        return record;
    }

    public void setRecord(VisitRecord record) {
        this.record = record;
    }
}
