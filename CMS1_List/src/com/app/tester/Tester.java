package com.app.tester;

import static com.app.tester.Validation.*;
//import com.app.custom_ordering.OrderDatabymail.*;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import com.app.core.CustomerData;//import com.app.custom_exec.OrderDatabymail;

import static com.app.Util.Utility.*;

public class Tester {
	public static void main(String[] args) {
		//int choice;
		try(Scanner in=new Scanner(System.in)) {
			boolean exit=false;
			//String check;
			System.out.println("Enter the max size :");
			List<CustomerData> mylist=new ArrayList<>();
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
		   
		    		CustomerData myarr=ValidateEntry(in.next(),in.next(),in.next(),in.next(),in.nextDouble(),in.next(),in.next(),mylist);
		    		mylist.add(myarr);
		    		//CustomerData arr[counter]=new CustomerData(in.next(),in.next(),in.next(),in.next(),in.nextDouble(),in.next(),in.next());
		    		System.out.println("sin-up completed");
		    		break;
		    	case 2:
		    		System.out.println("please enter email and password");
		    		String s=userSignIn(in.next(),in.next(),mylist);
		    		System.out.println(s);
		    		
		    		break;
		    	case 3:
		    		System.out.println("please enter email and password to unsubscribe");
		    		String p=userinsubscribe(in.next(),in.next(), mylist);
		    		System.out.println(p);
		    		break;
		    	case 4:
		    		System.out.println("Please enter your emailid and newpassword");
		    		System.out.println(changepass(in.next(),in.next(),mylist));
		    		break;
		    		
		    	case 5:
		    		System.out.println("details are");
		    		for(CustomerData d:mylist) 
		    				System.out.println(d);
		    		break;
		    	case 6:
		    		Collections.sort(mylist);
		    		break;
		    	case 7:
		    		Collections.sort(mylist,new Comparator<CustomerData>() {

						@Override
						public int compare(CustomerData o1, CustomerData o2) {
							int retVal = o1.getDob().compareTo(o2.getDob());
							if (retVal == 0) {
								return (o1.getLast_name()).compareTo(o2.getLast_name());
							}
							return retVal;
						}
		    			
		    		});
		    		break;
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


