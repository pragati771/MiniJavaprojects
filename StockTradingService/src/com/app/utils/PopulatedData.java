package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.stock.Stocks;

public class PopulatedData {
   public static List<Stocks> populateList(){
	   List<Stocks> mylistt=new ArrayList<>();
	   mylistt.add(new Stocks(1,"Paint","AsianPaints",200,LocalDate.parse("2024-08-07"),50));
	   mylistt.add(new Stocks(2,"motors","TATA",100,LocalDate.parse("2024-04-07"),50));
	   mylistt.add(new Stocks(3,"Britannia","Britannia",400,LocalDate.parse("2024-01-07"),50));
	   mylistt.add(new Stocks(5,"Nestle","Nestle",100,LocalDate.parse("2024-04-07"),50));
	   mylistt.add(new Stocks(4,"Buist","Nestle",100,LocalDate.parse("2024-07-07"),50));
	   
	return mylistt;
	   
   }
   
   public static  Map<Integer,Stocks> populatemap(List<Stocks> list){
   Map<Integer,Stocks> mymap=new HashMap<>();
   
   for(Stocks l:list) {
	   mymap.put(l.getSid(), l);
   }
return mymap;
}
}
