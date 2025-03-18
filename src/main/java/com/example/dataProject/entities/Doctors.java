package com.example.dataProject.entities;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Doctors {

    public Doctors(){
    }

    public Doctors(int id, String name, String surname, Departments department, LocalDate hire_date){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.hire_date = hire_date;
    }

    @Id
    @Column
    private int id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name="surname", nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn (name="department", referencedColumnName = "id", nullable = false)
    private Departments department;

    @Column(name="hire_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hire_date;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true)
    private List<Patients> patients;

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

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }
}
