package com.blogs.services;

import java.util.List;
import java.util.Optional;
//import org.modelmapper.internal.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.entities.Patients;
import com.blogs.repository.PatientRepository;
@Service
@Transactional
public class PatientServiceimpl implements PatientService {
  @Autowired
  public PatientRepository rep;

@Override
public Patients addPatientDetails(Patients p) {
	
	return rep.save(p);
			
}

@Override
public List<Patients> AllPatientDetails() {

	return rep.getAllPatients();
}

@Override
public Patients getByIdDetail(Long pid) {
	Optional<Patients> option=rep.findById(pid);
	return option.orElseThrow();
}

@Override
public String updatePatientDetails(Long pid, Patients patient) {
	if(rep.existsById(pid)) {
		Patients p= new Patients(pid,patient.getEmail(),patient.getFirstName(),patient.getLastName(),
				patient.getPassword());
		rep.save(p);
		return "data updated";
	}
	return "please give valid id to update";
}
  
}
