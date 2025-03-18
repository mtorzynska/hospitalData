package com.example.dataProject.repositories;

import com.example.dataProject.entities.Doctors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorsRepository extends CrudRepository<Doctors, Integer>, PagingAndSortingRepository<Doctors, Integer> {

    @Query("SELECT count(*) FROM Doctors d WHERE d.id = ?1")
    public Integer checkIfExists(int id);

    @Query("Select count(d) from Doctors d")
    public Integer countAllDoctors();

    @Query("select d FROM Doctors d ORDER BY d.id")
    Page<Doctors> getDoctorsPaging(Pageable pageable);

}
