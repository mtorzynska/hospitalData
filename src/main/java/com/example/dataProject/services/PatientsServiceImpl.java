package com.example.dataProject.services;

import com.example.dataProject.entities.Patients;
import com.example.dataProject.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientsServiceImpl implements PatientsService{

    @Autowired
    private  PatientsRepository patientsRepository;

    public List<Patients> getAllPatients(){
        List<Patients> list = new ArrayList<>();
        patientsRepository.findAll().forEach(list::add);
        return list;
    }

    public Patients getPatient(int id){
        return patientsRepository.findById(id).orElse(null);
    }

    public void addPatient(Patients patient){
        patientsRepository.save(patient);
    }

    public void updatePatient(int id, Patients patient){
        Patients updatedPatient = patientsRepository.findById(id).get();
        updatedPatient.setBirth_date(patient.getBirth_date());
        updatedPatient.setDoctor(patient.getDoctor());
        updatedPatient.setName(patient.getName());
        updatedPatient.setSurname(patient.getSurname());
        patientsRepository.save(updatedPatient);
    }

    public void deletePatient(int id){
        patientsRepository.deleteById(id);
    }

    public boolean checkIfExists(int id){
        return (patientsRepository.checkIfExist(id) > 0);
    }
}
