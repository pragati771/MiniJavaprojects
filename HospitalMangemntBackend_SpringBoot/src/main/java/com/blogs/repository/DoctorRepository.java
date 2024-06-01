package com.blogs.repository;

//import org.modelmapper.internal.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blogs.entities.Doctors;
import com.blogs.entities.Patients;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors, Long> {

 public Optional<Doctors> findByName(String name);

}
