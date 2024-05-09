package com.app.tester;

import static com.app.tester.Validation.*;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import static com.app.Util.IOUtility.*;
import static com.app.Util.CustomerCollectionUtils.*;
import com.app.core.CustomerData;//import com.app.custom_exec.OrderDatabymail;

import static com.app.Util.Utility.*;

public class Tester {
	public static void main(String[] args) {
		//int choice;
		try(Scanner in=new Scanner(System.in)) {
			boolean exit=false;
			String name;
			//String check;
			System.out.println("Enter the max size :");
			//List<CustomerData> mylist=new ArrayList<>();
			Map<String,CustomerData> mymap=populateMap(populateList());
			System.out.println("enter the file name");
    		name=in.next();
    		try {
				WriteDetails(mymap,name);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(!exit) {
		    	System.out.println("Please choose your field: ");
		    	System.out.println("1: sign-up,  2:sign-in  , 3:un-subscribe ,  4:changepass , 5: showall, 6: order by email ,7: orderby Dob and lastname 0:exit");
		    	try {
		    	switch(in.nextInt()) {
		    	case 0:
		    		exit=true;
		    		break;
		    	case 1:
		    		
		    		System.out.println("enter:first_name last_name email  password "+
		    				 "registrationAmount dob plan");
		    		
		   
		    		CustomerData myarr=ValidateEntry(in.next(),in.next(),in.next(),in.next(),in.nextDouble(),in.next(),in.next(),mymap);
		    		//mylist.add(myarr);
		    		mymap.put(myarr.getEmail(),myarr);
		    		WriteDetails(mymap,name);
		    		//CustomerData arr[counter]=new CustomerData(in.next(),in.next(),in.next(),in.next(),in.nextDouble(),in.next(),in.next());
		    		System.out.println("sin-up completed");
		    		break;
		    	case 2:
		    		System.out.println("please enter email and password");
		    		if(userSignIn(in.next(),in.next(),mymap)) {
		    			System.out.println("login sucessfull!!..........");
		    		}
		    		else {
		    			System.out.println("something is wrong try again");
		    		}
		    		
		    		break;
		    	case 3:
		    		System.out.println("please enter email and password to unsubscribe");
		    		String p=userinsubscribe(in.next(),in.next(), mymap);
		    		System.out.println(p);
		    		break;
		    	case 4:
		    		System.out.println("Please enter your emailid and newpassword");
		    		System.out.println(changepass(in.next(),in.next(),mymap));
		    		break;
		    		
		    	case 5:
		    		System.out.println("details are");
		    		Map<String,CustomerData> newmap=ReadDetails(name);
		    		newmap.forEach((k,v)->System.out.println(v));
		    		
//		    		for(CustomerData value:mymap.values()) {
//		    			System.out.println(value);
//		    		}
		    		break;
//		    	case 6:
//		    		Collections.sort(mylist);
//		    		break;
//		    	case 7:
//		    		Collections.sort(mylist,new Comparator<CustomerData>() {
//
//						@Override
//						public int compare(CustomerData o1, CustomerData o2) {
//							int retVal = o1.getDob().compareTo(o2.getDob());
//							if (retVal == 0) {
//								return (o1.getLast_name()).compareTo(o2.getLast_name());
//							}
//							return retVal;
//						}
//		    			
//		    		});
//		    		break;
		    	default:
		    		System.out.println("invalid choice");
		    		break;
		    	}}catch(Exception e) {
		    		System.out.println(e);
		    		in.nextLine();
		    	}
		    	}
		    }
		System.out.println("byee----------------------------------------------------------");
		}
		
	}
//       pragati kumrawat pk@gmail.com 90Ji@ghjiuy 2000 2001-09-09 gold

