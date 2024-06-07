package com.app.tester;

import static com.app.utils.Validation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static com.app.utils.PopulatedData.*;
import com.app.stock.Stocks;
import static com.app.utils.IOUtils.*;
public class Tester {
 public static void main(String[] args) {
	 try(Scanner sc=new Scanner(System.in)){
		 Map<Integer,Stocks> mymap=populatemap(populateList());
		 boolean flag=true;
		 System.out.println("Hello Welcome to Stock TRading SErvice");
		 String fname;
		 System.out.println("Enter file name to store data");
		 fname=sc.next();
		 
		
		 while(flag) {
			 System.out.println("Choose your operation");
			 System.out.println("1:Add new Stock\n2:Search Stock by Company\n3:Purhase Stock\n4:Sell Stock\n5:show all\n0:exit");
			 try {
			 switch(sc.nextInt()) {
			 // String sname, String companyname, double price, LocalDate closingdate, int quantity) {
			 case 1:
				 System.out.println("enter sid,sname, companyname,  price, closingdate, quantity) ");
				 Stocks s=addMyStockData(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.nextInt(),mymap);
				 mymap.put(s.getSid(), s);
				 writeDetails(mymap,fname);
				 System.out.println("donee");
				 break;
			 case 2:
				 System.out.println("Enter company name to serch it's stock");
				 List<Stocks> mylis=getByCompanyName(sc.next(),mymap);
				 System.out.println(mylis);
				 break;
			 case 3:
				 System.out.println("Welcome to shop");
				 System.out.println("Enter id and number of stock to purchase");
				 Stocks stock=purchaseStock(sc.nextInt(),sc.nextInt(),mymap);
				 mymap.put(stock.getSid(), stock);
				 System.out.println(""+stock.getCompanyname()+" are purchased sucessfully!!!");
				 writeDetails(mymap,fname);
				 break;
			 case 4:
				 System.out.println("WElcome and happy sell your stock");
				 System.out.println("Please Enter id and quantity");
				 Stocks stock2= sellStock(sc.nextInt(),sc.nextInt(),mymap);
				  mymap.put(stock2.getSid(), stock2);
				 System.out.println(""+stock2.getCompanyname()+" are sold sucessfully!!!");
				 writeDetails(mymap,fname);
				 break;
			 case 5:
				 getDetails(fname).values().forEach(v->System.out.println(v));
				 break;
			
			 case 0:
				 writeDetails(mymap,fname);
				 flag=false;
				 break;
			 }
			 
			 
		 }catch(Exception e) {
			 System.out.println(e);
	    		sc.nextLine();
		 }
		 
		 
	 }
 }
}}
