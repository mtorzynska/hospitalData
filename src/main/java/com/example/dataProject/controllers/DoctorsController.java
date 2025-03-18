package com.example.dataProject.controllers;

import com.example.dataProject.entities.Doctors;
import com.example.dataProject.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping(value = "/doctors")
    public List<Doctors> getAllDoctors() {
        return doctorsService.getAllDoctors();
    }

    @GetMapping(value = "/doctors/{id}")
    public Doctors getDoctorById(@PathVariable int id) {
        return doctorsService.getDoctor(id);
    }

    //fixed size pages
    @GetMapping("/doctors/pages")
    public Page<Doctors> getDoctorsPaging(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size) {
        page=page-1;
        return doctorsService.getDoctorsPaging(page, size);
    }

    @GetMapping(value = "/doctors/size={pageSize}/page={pageNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Doctors> list(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return doctorsService.getDoctorsPaging(pageNumber-1, pageSize);
    }

    @PostMapping(value = "/doctors/add")
    public void addDoctor(@RequestBody Doctors doctor) {
        doctorsService.addDoctor(doctor);
    }

    @PutMapping(value = "/doctors/update/{id}")
    public void updateDoctor(@RequestBody Doctors doctor, @PathVariable int id) {
        doctorsService.updateDoctor(id, doctor);
    }


    @DeleteMapping(value = "/doctors/delete/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorsService.deleteDoctor(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException500(Exception ex) {
        return "Sorry! Something went wrong.";
    }

}