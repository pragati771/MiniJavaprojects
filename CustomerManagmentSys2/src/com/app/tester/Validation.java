package com.app.tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import com.app.core.CustomerData;
import com.app.core.serviceplan;
import com.app.custom_exec.MyCustomException;
//import java.time.;
//import static com.app.Util.Utility.*;

public class Validation {
	public static CustomerData ValidateEntry(String first_name, String last_name, String email, String password,
			double registrationAmount, String dob, String plan, Map<String,CustomerData> mymap) throws MyCustomException{
		noduplicatepk(email,mymap);
		validatemail(email);
		validatmypassword(password,mymap);
	
		 LocalDate mydate=parseandvalidatedob(dob);
		 serviceplan myplan=parseSting(plan);
		 validatemypayment(myplan,registrationAmount);
		 return new CustomerData (first_name, last_name, email, password,
					 registrationAmount, mydate, myplan);
		
	}
	
	public static LocalDate parseandvalidatedob(String dob) throws MyCustomException {
		 
		LocalDate mydate=LocalDate.parse(dob);
		int age=Period.between(mydate, LocalDate.now()).getYears();
		if(age<21) {
			throw new MyCustomException("You are underage");
		}
		return mydate;
	}
	public static serviceplan parseSting(String plan) {
		return serviceplan.valueOf(plan.toUpperCase());
	}
	
	//given mail is correct or not
   public static void validatemail(String email) throws MyCustomException {
	   
	   //boolean flag=true;
	   if(!email.contains("@")){
		   throw new MyCustomException("Not a valid mail '@' is missing");  
	   }
	   if(email.endsWith(".com")|| email.endsWith(".org")|| email.endsWith(".net")) {
	    }
	    else {
    	throw new MyCustomException("Not valid organization of mail");
	    }
   }
   
   //to check if the amount for chosen plan is valid
   public static void  validatemypayment( serviceplan myplan,double registrationAmount) throws MyCustomException {
	   if((myplan.getCharge())==registrationAmount) {
		   
	   }
	   else {
		   throw new MyCustomException("wrong amount please verify again");
	   }
   }
   
   public static void noduplicatepk(String mail,Map<String,CustomerData> mymap) throws MyCustomException {
	 
	   if(mymap.containsKey(mail)) {
		   throw new MyCustomException("Error! email alredy exists");
	   }
   }
   public static void validatmypassword(String password,Map<String,CustomerData> mymap) throws MyCustomException {
	   String regEx="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
	   if(password.matches(regEx)) {
	   }
	   else {
		   throw new MyCustomException("Password is weak please try again");

	   }

   }}


