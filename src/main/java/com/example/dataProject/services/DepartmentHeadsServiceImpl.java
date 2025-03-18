package com.example.dataProject.services;

import com.example.dataProject.entities.DepartmentHeads;
import com.example.dataProject.repositories.DepartmentHeadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentHeadsServiceImpl implements DepartmentHeadsService{

    @Autowired
    DepartmentHeadsRepository departmentHeadsRepository;

    public List<DepartmentHeads> getAllDepartmentHeads(){
        List<DepartmentHeads> list = new ArrayList<>();
        departmentHeadsRepository.findAll().forEach(list::add);
        return list;
    }

    public DepartmentHeads getDepartmentHead(int id){
        return departmentHeadsRepository.findById(id).orElse(null);
    }

    public void addDepartmentHead(DepartmentHeads head){
        departmentHeadsRepository.save(head);
    }

    public void updateDepartmentHead(int id, DepartmentHeads head){
        if(checkIfExists(id)){
        DepartmentHeads updatedHead = departmentHeadsRepository.findById(id).get();
        updatedHead.setHead_id(head.getHead_id());
        updatedHead.setDepartment(head.getDepartment());
        departmentHeadsRepository.save(updatedHead);
        }
        else{
            System.out.println("Couldn't find id.");
        }
    }

    public void deleteDepartmentHead(int id){
        departmentHeadsRepository.deleteById(id);
    }

    public boolean checkIfExists(int id){
        return (departmentHeadsRepository.checkIfExists(id) > 0);
    }
}
