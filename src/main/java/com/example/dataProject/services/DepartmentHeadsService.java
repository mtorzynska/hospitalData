package com.example.dataProject.services;


import com.example.dataProject.entities.DepartmentHeads;
import com.example.dataProject.entities.Departments;

import java.util.List;

public interface DepartmentHeadsService {

    List<DepartmentHeads> getAllDepartmentHeads();

    DepartmentHeads getDepartmentHead(int id);

    void addDepartmentHead(DepartmentHeads head);

    void updateDepartmentHead(int id, DepartmentHeads head);

    void deleteDepartmentHead(int id);

    boolean checkIfExists(int id);

}
