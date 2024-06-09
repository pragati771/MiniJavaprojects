package com.app.tester;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.employee.Employee;
import com.app.employee.Type;
import static com.app.utils.Validations.*;
public class Tester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			Map<Integer,Employee> mymap=new HashMap<>();
			boolean flag=true;
			System.out.println("Welcome to Employee Manangement SYstem");
			while(flag) {
				System.out.println("Enter yor choice");
				System.out.println("1:Add full time employee\n2:Add part time employee\n3:Delete by empid\n4:serch by adhaar number\n5:display all\n6:sort by joining date and display\n0:Exit");
			    try {
				switch(sc.nextInt()) {
			    case 1:
			    	System.out.println("Please enter following details");
			    	System.out.println("name,joining date, phone number,aadhaar number, sal");
			    	Employee e=validateFTEData(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),mymap);
			    	System.out.println(e);
			    	mymap.put(e.getId(), e);
			    	break;
			    case 2:
			    	System.out.println("Please enter following details");
			    	System.out.println("name,joining date, phone number,aadhaar number, sal");
			    	Employee e1=validatePTEData(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),mymap);
			    	mymap.put(e1.getId(), e1);
			    	break;
			    case 3:
			    	System.out.println("Please enter id to delete");
			    	System.out.println(deleteById(sc.nextInt(),mymap));
			    	break;
			    case 4:
			    	System.out.println("please enter aadhar");
			    	Employee ee=searchByAdhar(sc.next(),mymap);
			    	
			    	System.out.println(ee);
			    	break;
			    case 5:
			    	System.out.println(mymap.values());
			    	break;
			    case 6:
			    	System.out.println("sorting data by joining date");
			    	Map<Integer,Employee> newmap=new TreeMap<Integer, Employee>(new Comparator<Integer>() {

						@Override
						public int compare(Integer o1, Integer o2) {
							return	mymap.get(o1).getJoining().compareTo(mymap.get(o2).getJoining());	
						}
			    		
			    	});
			    	for (Integer key : mymap.keySet()) {
			    	    newmap.put(key, mymap.get(key));
			    	}
			    	System.out.println(newmap);
			    	break;
			    case 0:
			    	flag=false;
			    	break;
			    }
			    }catch(Exception e) {
			    	e.getMessage();
			    }
			
			}
			
		}

	}

}
//   pragati 2020-09-09 1234567899 123123123123 3456
//  pk 2023-09-09 1234123412 123456789012 567