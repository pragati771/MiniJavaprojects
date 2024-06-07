package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.exception.CustomExc;
import com.app.stock.Stocks;

public class Validation {
       public static Stocks addMyStockData(int id,String sname, String companyname, double price, String closingdate, int quantity
    		   , Map<Integer,Stocks> mymap) throws CustomExc {
    	   LocalDate date=LocalDate.parse(closingdate);
    	   if(mymap.containsKey(id)==false) {
    		   if(date.isAfter(LocalDate.now())){
    			   return new Stocks(id,sname,companyname,price,date,quantity);
    		   }
    		   else {
    			   throw new CustomExc("Date is not correct:Enter future date");
    		   }
    	   }else {
    		   throw new CustomExc("Duplicate key Error");
    	   }
    	   
       }
       
       // to search stock by company name let's return a list 
       public static List<Stocks> getByCompanyName(String companyname, Map<Integer, Stocks> mymap) throws CustomExc {
    	    // Check if companyname or mymap is null
    	    if (companyname == null || mymap == null) {
    	        throw new CustomExc("Company name or map cannot be null");
    	    }

    	    // List to store matching stocks
    	    List<Stocks> mylistt = new ArrayList<>();

    	    // Iterate through the map values and find matching company names
    	    for (Stocks s : mymap.values()) {
    	    	System.out.println("in iter");
    	        if (companyname.equals(s.getCompanyname())) {
    	        	System.out.println("oohoo");
    	            mylistt.add(s);
    	        }
    	    }
       System.out.println(mylistt);
    	    return mylistt;
    	}
       
       //to purchase available stock and than update the data
       public static Stocks purchaseStock(int id,int qty, Map<Integer,Stocks> mymap) throws CustomExc {
    	   if(mymap.containsKey(id)) {
    		  Stocks s=mymap.get(id);
    		   System.out.println(s.getQuantity());
    		   if(s.getQuantity()>=qty) {
    			   s.setQuantity(s.getQuantity()-qty);
    			   return s;
    			   
    		   }
    		   else {
    			   throw new CustomExc("Oops!! Expected Stocks not present"); 
    		   }
    	   }
    	   else {
    		   throw new CustomExc("Invalid stock id");  
    	   }
		
    	   
       }
       
       // to sell stock and update data
       public static Stocks sellStock(int id,int qty, Map<Integer,Stocks> mymap) throws CustomExc {
    	   if(mymap.containsKey(id)) {
     		  Stocks s=mymap.get(id);
     		   System.out.println(s.getQuantity());
     			   s.setQuantity(s.getQuantity()+qty);
     			   return s;
     			   
     		  
     	   }
     	   else {
     		   throw new CustomExc("Invalid stock id");  
     	   }
 		
		
    	   
       }

    	  
       }

