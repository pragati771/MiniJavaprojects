package com.app.employee;

import java.time.LocalDate;

public class Employee {
	public int id;
	 public String Name;
	 private LocalDate joining;
	 private String Number;
	 private String Aadhaar;
	 private Type etype;
	 private String sal;
	 public static int num=1;
	public Employee(String name, LocalDate joining, String number, String aadhaar) {
		super();
		Name = name;
		this.joining = joining;
		Number = number;
		Aadhaar = aadhaar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public LocalDate getJoining() {
		return joining;
	}
	public void setJoining(LocalDate joining) {
		this.joining = joining;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getAadhaar() {
		return Aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		Aadhaar = aadhaar;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", joining=" + joining + ", Number=" + Number + ", Aadhaar="
				+ Aadhaar + ", etype=" + etype + "]";
	}
	public Type getEtype() {
		return etype;
	}
	public Employee(String name, LocalDate joining, String number, String aadhaar, Type etype, String sal) {
		super();
		id=num;
		Name = name;
		this.joining = joining;
		Number = number;
		Aadhaar = aadhaar;
		this.etype = etype;
		this.sal = sal;
		num++;
	}


	 
	 
}
