package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Patients;
import com.blogs.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patients createPatient(@RequestBody Patients patient) {
        return patientService.addPatientDetails(patient);
    }
    @GetMapping
    public List<Patients> showAllPatient() {
        return patientService.AllPatientDetails();
    }
    @GetMapping("/{pid}")
    public Patients getPatientById(@PathVariable Long pid) {
		return patientService.getByIdDetail(pid);
    }
    @PostMapping("/{pid}")
    public String updatePatient(@PathVariable Long pid,@RequestBody Patients patient) {
        return patientService.updatePatientDetails(pid,patient);
    }
}

