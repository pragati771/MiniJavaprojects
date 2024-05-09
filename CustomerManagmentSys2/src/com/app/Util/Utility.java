package com.app.Util;
import java.util.List;
import java.util.Map;

import com.app.core.CustomerData;
import com.app.custom_exec.MyCustomException;
public class Utility {
	public static boolean userSignIn(String email,String password,Map<String,CustomerData> mymap) throws MyCustomException {
		CustomerData c= mymap.get(email);
		if(mymap.containsKey(email)) {
			return c.getPassword().equals(password);
			
		}
		else {
			throw new MyCustomException("Invalid Email-ID");
		}
//		//int index=mylist.indexOf(mail);
//		System.out.println(index);
//		if(index==-1) {
//			throw new MyCustomException("Invalid Email-ID");}
//		else {
//			if(((mylist.get(index)).getPassword()).equals(password)) {
//				return "Login sucessfull!!!!!!";
//			}
//			else {
//				throw new MyCustomException("Incorrect password");
			//}
		//}
	}
	
	//to unsubscribe
	public static String userinsubscribe(String email,String password,Map<String,CustomerData> mymap) throws MyCustomException {
		//firstly i will chk if usersign in correct or not
		if(mymap.containsKey(email)) {
			mymap.remove(email);
			return "un-subscribe sucessfully!! hope to see you again";
		}
		else {
			throw new MyCustomException("please enter valid mail");
		}
//		userSignIn(email,password,mylist);
//      CustomerData mail= new CustomerData(email);
//		
//		int index=mylist.indexOf(mail);
//		mylist.remove(index);
//		return "un-subscribe sucessfully!! hope to see you again";
	}
	
	//to change password
	public static String changepass(String email,String newpassword,Map<String,CustomerData> mymap) throws MyCustomException {
             CustomerData d = mymap.get(email);
             if(d==null) {
            	 throw new MyCustomException("please enter valid mail");
             }
             else {
            	 d.setPassword(newpassword);
            	}

			return "password changed succesfully!!";
		}
	}

 //       pk pk pk@gmail.com pk@hjgY7h 2000 2001-09-09 gold
//          kj kj kj@gmail.com kj78Hjg#hj 2000 2001-09-09 gold
