package com.example.dataProject.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Departments")
public class Departments{

    public Departments(){}

    public Departments(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    @Column
    private int id;

    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private List<Doctors> doctors;

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
}

