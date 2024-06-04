package com.app.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

import com.app.pen.Pen;

public class Utilss {
public static String updatedata(int id,int stock,List<Pen> mylist) {
	Pen mypen=new Pen(id);
	for(Pen p:mylist) {
		if(p!=null && p.equals(mypen)) {
			p.setStock(stock);
			p.setUpdatedate(LocalDate.now());
			return "Stock Updated Sucessfully!!";
		}
	}
	return "Something went wrong please try again";
	
}

// to update discount
public static String addDiscount(int discount,List<Pen> mylist) {
	
	for(Pen p:mylist) {
		if(p!=null) {
			long num=ChronoUnit.MONTHS.between(p.getUpdatedate(),LocalDate.now());
			if(num>=3) {
				p.setDiscount(discount);
			}
			return "Discount applied!!";
		}
	}
	return "Something went wrong please try again";
	
}


public static String removePen(List<Pen> mylist) {
	Iterator<Pen> myitr=mylist.iterator();
	while(myitr.hasNext()) {
		long num=ChronoUnit.MONTHS.between((myitr.next()).getUpdatedate(),LocalDate.now());
		if(num>=9) {
			myitr.remove();
			return "Data deleted";
		}
	
	}
	return "Something went wrong please try again";
	
}

}
