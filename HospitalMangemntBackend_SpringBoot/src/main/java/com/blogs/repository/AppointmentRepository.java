package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogs.dto.GetAppointmentDTO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogs.entities.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//
//    @Query("SELECT new com.blogs.dto.GetAppointmentDTO(a.appointmentDate, a.appointmentTime) FROM Appointment a WHERE a.did = :doctorId")
//    List<GetAppointmentDTO> getMyDetByDoctorId(@Param("doctorId") Long doctorId);
	
	@Query("Select new com.blogs.dto.GetAppointmentDTO(a.patient.id,a.appointmentDate,a.appointmentTime) from Appointment a Where a.doctor.did=:doctorId")
	List<GetAppointmentDTO> MyDetails(Long doctorId);
}
