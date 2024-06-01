package com.blogs.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exception.ApiException;
import com.blogs.dto.ApiResponse;

import com.blogs.dto.ApponitmentDTO;
import com.blogs.dto.GetAppointmentDTO;
import com.blogs.entities.Appointment;
import com.blogs.entities.Doctors;
import com.blogs.entities.Patients;
import com.blogs.repository.AppointmentRepository;
import com.blogs.repository.DoctorRepository;
import com.blogs.repository.PatientRepository;
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	
	
 @Autowired
 private AppointmentRepository appointmentrespository;
 @Autowired
 private ModelMapper mappe;
 @Autowired
 private PatientRepository patientrepository;
 @Autowired
 private DoctorRepository doctorRepository;
 
 
	@Override
	public ApiResponse createAppoint(ApponitmentDTO app) {
		// get doctors
		Doctors doctor=doctorRepository.findByName(app.getName())
				.orElseThrow(()->new ApiException("Invalid doctors id"));
		// get Patient
		Patients patient=patientrepository.findByFirstName(app.getFirstName())
				.orElseThrow(()->new ApiException("Invalid doctors id"));
		// map from dto
		Appointment appnt=mappe.map(app, Appointment.class);
		// set doctors
		appnt.setDoctor(doctor);
		//set patient
		appnt.setPatient(patient);
		// save the data
		Appointment myapp=appointmentrespository.save(appnt);
				
		return new ApiResponse("Appointment added for Doctor "+app.getName()+
				" on "+app.getAppointmentDate()+" at "+app.getAppointmentTime());
	}


	@Override
	public List<GetAppointmentDTO> showMyAppointment(Long doctorId) {
		List<GetAppointmentDTO> test=appointmentrespository.MyDetails(doctorId)
		.stream()
		.map(Appointment->mappe.map(Appointment, GetAppointmentDTO.class))
		.collect(Collectors.toList());
		return test;
	}


	@Override
	public ApiResponse deleteMyAppointment(Long appointmentId) {
		appointmentrespository.deleteById(appointmentId);
		return new ApiResponse("AppointmmentID "+appointmentId+" Deleted sucessfully!!");
	}

}
