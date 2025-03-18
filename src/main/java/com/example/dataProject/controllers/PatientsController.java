package com.example.dataProject.controllers;

import com.example.dataProject.entities.Patients;
import com.example.dataProject.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @GetMapping(value = "/patients")
    public List<Patients> getPatients(){
        return patientsService.getAllPatients();
    }

    @GetMapping(value = "/patients/{id}")
    public Patients getPatient(@PathVariable int id){
        return patientsService.getPatient(id);
    }

    @PostMapping(value = "/patients/add")
    public void addPatient(@RequestBody Patients patients){
        if(!patientsService.checkIfExists(patients.getId())){
            patientsService.addPatient(patients);
        }
        else handleException500(new Exception("Id exists already"));
    }

    @PutMapping(value = "/patients/update/{id}")
    public void updatePatient(@RequestBody Patients patient, @PathVariable int id){
        patientsService.updatePatient(id, patient);
    }

    @DeleteMapping(value = "/patients/delete/{id}")
    public void deletePatient(@PathVariable int id){
        patientsService.deletePatient(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException500(Exception ex) {
        return "Sorry! Something went wrong.";
    }

}
