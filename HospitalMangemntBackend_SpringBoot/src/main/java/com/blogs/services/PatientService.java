package com.blogs.services;

import java.util.List;

import com.blogs.entities.Patients;

public interface PatientService {
	 public Patients addPatientDetails(Patients p);

	public List<Patients> AllPatientDetails();

	public Patients getByIdDetail(Long pid);

	public String updatePatientDetails(Long pid, Patients patient);
}
