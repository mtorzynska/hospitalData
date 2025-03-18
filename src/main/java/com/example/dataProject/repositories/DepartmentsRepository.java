package com.example.dataProject.repositories;

import com.example.dataProject.entities.Departments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends CrudRepository<Departments, Integer> {

    @Query("SELECT count(*) FROM Departments d WHERE d.id = ?1")
    Integer checkIfExist(Integer id);

}
