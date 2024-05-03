package com.app.core;

import java.time.LocalDate;

//import com.app.core.Customer;

//kj@gmail.com kj 


public class CustomerData implements Comparable<CustomerData>{
	private int customer_id;
	private static int counter=100;
	private String  first_name;
	private String last_name;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private serviceplan plan;
	//private int n;



	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public serviceplan getPlan() {
		return plan;
	}

	public void setPlan(serviceplan plan) {
		this.plan = plan;
	}
	
	
	public CustomerData(String first_name, String last_name, String email, String password,
			double registrationAmount, LocalDate dob, serviceplan plan) {
		super();
		this.customer_id =counter++;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}

	public CustomerData(String email2) {
		this.email = email2;
	}

	@Override
	public String toString() {
		return "Signup [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", password=" + password + ", registrationAmount=" + registrationAmount
				+ ", dob=" + dob + ", plan=" + plan + "]";
	}
	@Override
	public boolean equals(Object o)
	{
		System.out.println("in customer's equals");
		if(o instanceof CustomerData)
		{
			CustomerData c=(CustomerData)o;
			return this.email.equals(c.email);
		}
		//if the passed arg is not a Customer : ret false
		return false;
		
	}
	

	public CustomerData(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public int compareTo(CustomerData o) {
		return (this.email).compareTo(o.email);
	}

	public LocalDate getDob() {
		// TODO Auto-generated method stub
		return dob;
	}

	
	
		
	}
	

	



