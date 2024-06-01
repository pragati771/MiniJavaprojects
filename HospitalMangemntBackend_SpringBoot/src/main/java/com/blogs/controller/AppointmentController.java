package com.blogs.controller;

import java.util.List;
import com.blogs.dto.ApiResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApponitmentDTO;
import com.blogs.dto.GetAppointmentDTO;
import com.blogs.entities.Patients;
import com.blogs.services.AppointmentService;
import com.blogs.services.PatientService;

//import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService patientService;

    @PostMapping
    public ApiResponse createMyAppointment(@RequestBody ApponitmentDTO app) {
        return patientService.createAppoint(app);
    }
  
    @GetMapping("/{doctorId}/upcoming")
    public List<GetAppointmentDTO> showMyAppointment(@PathVariable Long doctorId){
		return patientService.showMyAppointment(doctorId) ;
    	
    }
    
    @GetMapping("/{appointmentId}")
    public ApiResponse deleteMyAppointment(@PathVariable Long appointmentId){
		return patientService.deleteMyAppointment(appointmentId);
    }
    
  
}

