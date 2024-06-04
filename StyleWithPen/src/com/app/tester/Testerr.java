package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.app.utils.Utilss.*;
import com.app.pen.Brand;
import com.app.pen.Pen;
import static com.app.utils.Populate.*;

public class Testerr {
  public static void main(String[] args) {
	  List<Pen> mylist=populateList();
	  System.out.println("Hello Welcome to StyleWithPen");
	  boolean flag=true;
	  
	  try(Scanner sc=new Scanner(System.in)) {
		  while(flag) {
	  System.out.println("Choose your operation");
	  System.out.println("1.Disply all \n2.ADD a pen \n3.update Stock \n4.Apply Discount on 3 month old stock\n5.Remove Unsold Pen0:Exit");
	  switch(sc.nextInt()) {
	  case 1:
		  for(Pen p:mylist) {
			  System.out.println(p);
		  }
		  break;
	  case 2:
		  System.out.println("Please enter data");
		  System.out.println("brand, color, inkColor, material, stock,\r\n"
		  		+ "	, price, discount");
		  mylist.add(new Pen(Brand.valueOf(sc.next().toUpperCase()),sc.next(),sc.next(),sc.next(),sc.nextInt()
				  ,LocalDate.now(),LocalDate.now(),sc.nextInt(),sc.nextFloat()));
		  System.out.println("data added sucessfully!!");
		  break;
	  case 3:
		  System.out.println("Please enter following data");
		  System.out.println("Enter id and updated stock");
		  String res=updatedata(sc.nextInt(),sc.nextInt(),mylist);
		  System.out.println(res);
		  break;
	  case 4:
		  System.out.println("Enter  discount");
		  String res2= addDiscount(sc.nextInt(),mylist);
		  System.out.println(res2);
		  break;
	  case 5:
		 System.out.println(removePen(mylist));
		  break;
	 
	  case 0:
		  flag=false;
		  break;
		
	  }
	  
		  }
	  }catch(Exception e) {
		  
	  }
  }
} 
// CELLO red red plastic 100 10 2