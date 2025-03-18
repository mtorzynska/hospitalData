package com.example.dataProject.controllers;

import com.example.dataProject.entities.Departments;
import com.example.dataProject.services.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    @GetMapping(value = "/departments")
    public List<Departments> getAllDepartments(){
        return departmentsService.getAllDepartments();
    }

    @GetMapping(value = "/departments/{id}")
    public Departments getDepartmentById(@PathVariable int id){
        return departmentsService.getDepartment(id);
    }

    @PostMapping(value = "/departments/add")
    public void addDepartment(@RequestBody Departments department){
        departmentsService.addDepartment(department);
    }

    @PutMapping(value = "/departments/update/{id}")
    public void updateDepartment(@RequestBody Departments department, @PathVariable int id){
        departmentsService.updateDepartment(id, department);
    }

    @DeleteMapping(value = "/departments/delete/{id}")
    public void deleteDepartment(@PathVariable int id){
        departmentsService.deleteDepartment(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException500(Exception ex) {
        return "Sorry! Something went wrong.";
    }
}
