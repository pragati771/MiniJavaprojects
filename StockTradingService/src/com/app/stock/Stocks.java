package com.app.stock;

import java.io.Serializable;
import java.time.LocalDate;

public class Stocks implements Serializable {
	private int sid ;
	private String sname ;
	private String companyname; 
	private double price;
	private LocalDate closingdate;
	private int quantity;
	public Stocks(String sname, String companyname, double price, LocalDate closingdate, int quantity) {
		super();
		this.sname = sname;
		this.companyname = companyname;
		this.price = price;
		this.closingdate = closingdate;
		this.quantity = quantity;
	}
	public Stocks(int sid) {
		super();
		this.sid = sid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getClosingdate() {
		return closingdate;
	}
	public void setClosingdate(LocalDate closingdate) {
		this.closingdate = closingdate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stocks [sid=" + sid + ", sname=" + sname + ", companyname=" + companyname + ", price=" + price
				+ ", closingdate=" + closingdate + ", quantity=" + quantity + "]";
	}
	public Stocks(int sid, String sname, String companyname, double price, LocalDate closingdate, int quantity) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.companyname = companyname;
		this.price = price;
		this.closingdate = closingdate;
		this.quantity = quantity;
	}
	
	
}
