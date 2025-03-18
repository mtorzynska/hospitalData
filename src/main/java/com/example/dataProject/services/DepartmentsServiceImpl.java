package com.example.dataProject.services;

import com.example.dataProject.entities.Departments;
import com.example.dataProject.repositories.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Override
    public List<Departments> getAllDepartments(){
        List<Departments> list = new ArrayList<>();
        departmentsRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Departments getDepartment(int id){
        return departmentsRepository.findById(id).orElse(null);
    }

    @Override
    public void addDepartment(Departments department){
        departmentsRepository.save(department);
    }


    @Override
    public void updateDepartment(int id, Departments department){
        Departments updatedDepartment = departmentsRepository.findById(id).get();
        updatedDepartment.setName(department.getName());
        departmentsRepository.save(updatedDepartment);
    }

    @Override
    public void deleteDepartment(int id){
        departmentsRepository.deleteById(id);
    }

    @Override
    public boolean checkIfExists(int id){
        return (departmentsRepository.checkIfExist(id) > 0);
    }
}
