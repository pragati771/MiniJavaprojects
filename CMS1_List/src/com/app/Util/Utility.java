package com.app.Util;
import java.util.List;

import com.app.core.CustomerData;
import com.app.custom_exec.MyCustomException;
public class Utility {
	public static String userSignIn(String email,String password,List<CustomerData> mylist) throws MyCustomException {
		CustomerData mail= new CustomerData(email);
		
		int index=mylist.indexOf(mail);
		System.out.println(index);
		if(index==-1) {
			throw new MyCustomException("Invalid Email-ID");}
		else {
			if(((mylist.get(index)).getPassword()).equals(password)) {
				return "Login sucessfull!!!!!!";
			}
			else {
				throw new MyCustomException("Incorrect password");
			}
		}
		
	}
	
	//to unsubscribe
	public static String userinsubscribe(String email,String password,List<CustomerData> mylist) throws MyCustomException {
		//firstly i will chk if usersign in correct or not
		userSignIn(email,password,mylist);
      CustomerData mail= new CustomerData(email);
		
		int index=mylist.indexOf(mail);
		mylist.remove(index);
		return "un-subscribe sucessfully!! hope to see you again";
	}
	
	//to change password
	public static String changepass(String email,String newpassword,List<CustomerData> mylist) throws MyCustomException {
CustomerData mail= new CustomerData(email);
CustomerData newpass= new CustomerData(newpassword);
		int index=mylist.indexOf(mail);
		System.out.println(index);
		if(index==-1) {
			throw new MyCustomException("Invalid Email-ID");}
		else {
			mylist.set(index,newpass);
			return "password changed succesfully!!";
		}
	}
}
 //       pk pk pk@gmail.com pk 2000 2001-09-09 gold
//          kj kj kj@gmail.com kj 2000 2001-09-09 gold
