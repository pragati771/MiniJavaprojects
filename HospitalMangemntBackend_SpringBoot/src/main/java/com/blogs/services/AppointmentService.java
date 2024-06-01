package com.blogs.services;
import java.util.List;

import com.blogs.dto.ApiResponse;

import com.blogs.dto.ApponitmentDTO;
import com.blogs.dto.GetAppointmentDTO;
import com.blogs.entities.Patients;

//import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface AppointmentService {

	ApiResponse createAppoint(ApponitmentDTO app);

	 List<GetAppointmentDTO> showMyAppointment(Long doctorId) ;

	ApiResponse deleteMyAppointment(Long appointmentId);

}
