package com.example.dataProject.repositories;

import com.example.dataProject.entities.Patients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends CrudRepository<Patients, Integer> {

    @Query("SELECT count(*) FROM Patients p WHERE p.id = ?1")
    Integer checkIfExist(Integer id);

}
