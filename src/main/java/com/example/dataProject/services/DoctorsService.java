package com.example.dataProject.services;

import com.example.dataProject.entities.Departments;
import com.example.dataProject.entities.Doctors;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DoctorsService {

    List<Doctors> getAllDoctors();

    Doctors getDoctor(int id);

    public Iterable<Doctors> getDoctorsPaging(Integer pageNr, Integer howManyOnPage);
    void addDoctor(Doctors doctor);

    void updateDoctor(int id, Doctors doctor);

    void deleteDoctor(int id);

    Page<Doctors> getDoctorsPaging(int page, int size);

    boolean checkIfExists(int id);

}
