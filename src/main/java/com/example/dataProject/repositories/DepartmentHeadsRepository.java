package com.example.dataProject.repositories;

import com.example.dataProject.entities.DepartmentHeads;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentHeadsRepository extends CrudRepository<DepartmentHeads, Integer> {

    @Query("SELECT count(*) FROM DepartmentHeads d WHERE d.head_id=?1")
    public Integer checkIfExists(int id);

}
