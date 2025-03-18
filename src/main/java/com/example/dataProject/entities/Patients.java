package com.example.dataProject.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Patients {

    public Patients(){}

    public Patients(int id, String name, String surname, Doctors doctor, LocalDate birth_date){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.doctor = doctor;
        this.birth_date = birth_date;
    }

    @Id
    @Column
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name="doctor", referencedColumnName = "id", nullable = false)
    private Doctors doctor;

    @Column(name = "birth_date")
    private LocalDate birth_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }
}
