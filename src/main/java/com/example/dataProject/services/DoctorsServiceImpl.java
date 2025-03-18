package com.example.dataProject.services;

import com.example.dataProject.entities.Doctors;
import com.example.dataProject.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorsServiceImpl implements DoctorsService{

    @Autowired
    private DoctorsRepository doctorsRepository;

    @Override
    public List<Doctors> getAllDoctors(){
        List<Doctors> list = new ArrayList<>();
        doctorsRepository.findAll().forEach(list::add);
        return list;
    };

    @Override
    public Doctors getDoctor(int id){
        return doctorsRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Doctors> getDoctorsPaging(Integer pageNr, Integer howManyOnPage) {
        return doctorsRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    public void addDoctor(Doctors doctor){
        doctorsRepository.save(doctor);
    }

    @Override
    public void updateDoctor(int id, Doctors doctor){
        Doctors updatedDoctor = doctorsRepository.findById(id).get();
        updatedDoctor.setDepartment(doctor.getDepartment());
        updatedDoctor.setName(doctor.getName());
        updatedDoctor.setSurname(doctor.getSurname());
        updatedDoctor.setHire_date(doctor.getHire_date());
        doctorsRepository.save(updatedDoctor);
    };

    @Override
    public void deleteDoctor(int id){
        doctorsRepository.deleteById(id);
    };

    @Override
    public Page<Doctors> getDoctorsPaging(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return doctorsRepository.getDoctorsPaging(pageable);
    }

    @Override
    public boolean checkIfExists(int id){
        return (doctorsRepository.checkIfExists(id) > 0);
    };
}
