package com.example.dataProject.controllers;

import com.example.dataProject.entities.DepartmentHeads;
import com.example.dataProject.services.DepartmentHeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class DepartmentHeadsController {

    @Autowired
    private DepartmentHeadsService departmentHeadsService;

    @GetMapping(value = "/heads")
    public List<DepartmentHeads> getAllHeads(){
        return departmentHeadsService.getAllDepartmentHeads();
    }

    @GetMapping(value = "/heads/{id}")
    public DepartmentHeads getDepartmentById(@PathVariable int id){
        return departmentHeadsService.getDepartmentHead(id);
    }

    @PostMapping(value = "/heads/add")
    public void addDepartment(@RequestBody DepartmentHeads head){
        departmentHeadsService.addDepartmentHead(head);
    }

    @PutMapping(value = "/heads/update/{id}")
    public void updateDepartment(@RequestBody DepartmentHeads head, @PathVariable int id){
        departmentHeadsService.updateDepartmentHead(id, head);
    }

    @DeleteMapping(value = "/department/delete/{id}")
    public void deleteDepartment(@PathVariable int id){
        departmentHeadsService.deleteDepartmentHead(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException500(Exception ex) {
        return "Sorry! Something went wrong.";
    }

}
