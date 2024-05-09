package com.app.custom_ordering;

import java.util.Comparator;

import com.app.core.CustomerData;


public class OrderDatabymail implements Comparator<CustomerData> {
 
@Override
public int compare(CustomerData o1, CustomerData o2) {
	int retVal = o1.getDob().compareTo(o2.getDob());
	if (retVal == 0) {
		return (o1.getLast_name()).compareTo(o2.getLast_name());
	}
	return retVal;
}
 }
