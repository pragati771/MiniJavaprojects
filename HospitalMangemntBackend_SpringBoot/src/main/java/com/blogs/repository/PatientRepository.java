package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blogs.entities.Doctors;
import com.blogs.entities.Patients;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {

	 @Query("SELECT p FROM Patients p")
    List<Patients> getAllPatients();
	 
	 public Optional<Patients> findByFirstName(String name);

    
}
