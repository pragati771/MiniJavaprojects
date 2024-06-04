package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.pen.Brand;
import com.app.pen.Pen;

public class Populate {
public static List<Pen> populateList(){
	 List<Pen> mylist=new ArrayList<>();
	 mylist.add(new Pen(Brand.valueOf("CELLO"),"Black","Black","Plastic",100
			  ,LocalDate.parse("2022-09-08"),LocalDate.parse("2021-08-08"),10,0));
	 mylist.add(new Pen(Brand.valueOf("REYNOLDS"),"Black","Red","Metal",100
			  ,LocalDate.parse("2024-01-08"),LocalDate.parse("2022-08-08"),200,0));
	 mylist.add(new Pen(Brand.valueOf("CELLO"),"Black","Black","Metal",100
			  ,LocalDate.parse("2024-05-08"),LocalDate.parse("2022-08-08"),200,0));
	 mylist.add(new Pen(Brand.valueOf("PARKER"),"Black","Pink","Alloy Steel",100
			  ,LocalDate.parse("2022-08-08"),LocalDate.parse("2022-08-08"),200,0));
	 
	return mylist;
}
}
