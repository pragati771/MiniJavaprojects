package com.app.tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.core.CustomerData;
import com.app.core.serviceplan;
import com.app.custom_exec.MyCustomException;
//import java.time.;


public class Validation {
	public static CustomerData ValidateEntry(String first_name, String last_name, String email, String password,
			double registrationAmount, String dob, String plan, List<CustomerData> mylist) throws MyCustomException{
		noduplicatepk(email,mylist);
		validatemail(email,mylist);
		validatmypassword(password,mylist);
	
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
   public static void validatemail(String email,List<CustomerData> mylist) throws MyCustomException {
	   //boolean flag=true;
	   CustomerData mail=new CustomerData(email);
	   if(mylist.contains(mail))
		   throw new MyCustomException("wrong email");
	   if(email.contains(".com")|| email.contains(".org")|| email.contains(".net")) {
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
   
   public static void noduplicatepk(String mail,List<CustomerData> mydata) throws MyCustomException {
	   CustomerData cus=new CustomerData(mail);
	   if(mydata.contains(cus)) {
		   throw new MyCustomException("Error! email alredy exists");
	   }
   }
   public static void validatmypassword(String password,List <CustomerData> mydata) throws MyCustomException {
	   String regEx="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
	   if(password.matches(regEx)) {
	   }
	   else {
		   throw new MyCustomException("Password is weak please try again");

	   }

   }}


