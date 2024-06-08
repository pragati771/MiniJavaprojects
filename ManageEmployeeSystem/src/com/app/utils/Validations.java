package com.app.utils;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import com.app.employee.Employee;
import com.app.employee.Type;
import com.app.exception.CustomException;

public class Validations {
	public static Employee validateFTEData(String name, String joining, String number, String aadhaar, String sal, Map<Integer,Employee> mymap) throws CustomException {
	    if (number.length() != 10 || !number.matches("^[0-9]{10}$")) {
	        throw new CustomException("Number can only contain 10 digits");
	    } else if (mymap.containsValue(aadhaar)) {
	        throw new CustomException("Invalid Aadhaar: Duplicate Aadhaar not allowed");
	    } else if (aadhaar.length() != 12 || !aadhaar.matches("^\\d{12}$")) {
	        throw new CustomException("Invalid Aadhaar: Aadhaar must be 12 digits");
	    } else {
	        return new Employee(name, LocalDate.parse(joining), number, aadhaar, Type.FTE, sal + "/month");
	    }
	}

	
	//for PTE 
	public static Employee validatePTEData(String name, String joining, String number, String aadhaar, String sal,Map<Integer,Employee> mymap) throws CustomException {
		 if (number.length() != 10 || !number.matches("^[0-9]{10}$")) {
		        throw new CustomException("Number can only contain 10 digits");
		    } else if (mymap.containsValue(aadhaar)) {
		        throw new CustomException("Invalid Aadhaar: Duplicate Aadhaar not allowed");
		    } else if (aadhaar.length() != 12 || !aadhaar.matches("^\\d{12}$")) {
		        throw new CustomException("Invalid Aadhaar: Aadhaar must be 12 digits");
		    } else {
		        return new Employee(name, LocalDate.parse(joining), number, aadhaar, Type.PTE, sal + "/month");
		    }
	
		
	}
	//delete by empid
	public static String deleteById(int id,Map<Integer,Employee> mymap) throws CustomException {
		Iterator<Employee> myitr=mymap.values().iterator();
		if(mymap.containsKey(id)) {
			while(myitr.hasNext()) {
				if(myitr.next().getId()==id) {
					myitr.remove();
				}
			}
			}
		else {
			throw new CustomException("Invalid ID");
		}
		return "deleted sucessfully!!";
		
	}
	
	//search by aadhar
	public static Employee searchByAdhar(String adhar,Map<Integer,Employee> mymap) throws CustomException {
		if(mymap.containsValue(adhar)) {
			for(Employee e:mymap.values()) {
				if(e.getAadhaar().equals(adhar)) {
					return e;
				}
			}
			
		}else {
			throw new CustomException("invalid aadhar");
		}
		
		return null;
		
	}
	

}
