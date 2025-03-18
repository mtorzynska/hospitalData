package com.example.dataProject.services;

import com.example.dataProject.entities.Departments;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentsService {

    List<Departments> getAllDepartments();

    Departments getDepartment(int id);

    void addDepartment(Departments department);

    void updateDepartment(int id, Departments department);

    void deleteDepartment(int id);

    boolean checkIfExists(int id);

}
