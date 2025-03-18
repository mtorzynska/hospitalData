package com.example.dataProject.services;

import com.example.dataProject.entities.Departments;
import com.example.dataProject.entities.Patients;

import java.util.List;

public interface PatientsService {

    List<Patients> getAllPatients();

    Patients getPatient(int id);

    void addPatient(Patients patient);

    void updatePatient(int id, Patients patient);

    void deletePatient(int id);

    boolean checkIfExists(int id);
}
