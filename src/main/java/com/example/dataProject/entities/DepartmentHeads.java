package com.example.dataProject.entities;

import jakarta.persistence.*;

@Entity
@Table

public class DepartmentHeads {

    public DepartmentHeads(){}

    public DepartmentHeads(Doctors head_id, Departments department){
        this.head_id = head_id;
        this.department = department;
    }

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name="head_id", referencedColumnName = "id", nullable = false)
    private Doctors head_id;

    @OneToOne
    @JoinColumn(name = "department", referencedColumnName = "id", unique = true, nullable = false)
    private Departments department;

    public Doctors getHead_id() {
        return head_id;
    }

    public void setHead_id(Doctors head_id) {
        this.head_id = head_id;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
