package com.app.pen;

import java.time.LocalDate;

public class Pen {
//	a.	ID (unique identifier for each Pen, should be generated automatically)
//	b.	Brand (Example:  Cello, Parker, Reynolds etc.)
//	c.	Color
//	d.	InkColor
//	e.	Material (Example: Plastic, Alloy Steel, Metal etc.)
//	f.	Stock (Available quantity)
//	g.	Stock Update Date (it changed every time when admin update stock or user order executed)
//	h.	Stock Listing Date (date on which product is added to site for sale)
//	i.	Price (in INR) 
//	j.	Discounts (in percentage)
	private int id;
	private Brand brand;
	private String color;
	private String inkColor;
	private String material;
	private int stock;
	private LocalDate updatedate;
	private LocalDate listingdate;
	private int price;
	private float discount;
	private static int count=1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getInkColor() {
		return inkColor;
	}
	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LocalDate getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}
	public LocalDate getListingdate() {
		return listingdate;
	}
	public void setListingdate(LocalDate listingdate) {
		this.listingdate = listingdate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Pen(Brand brand, String color, String inkColor, String material, int stock, LocalDate updatedate,
			LocalDate listingdate, int price, float discount) {
		super();
		this.id=count;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.updatedate = updatedate;
		this.listingdate = listingdate;
		this.price = price;
		this.discount = discount;
		count++;
	}
	
	@Override
	public String toString() {
		return "pen [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stock=" + stock + ", updatedate=" + updatedate + ", listingdate=" + listingdate
				+ ", price=" + price + ", discount=" + discount + ", count=" + count + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Pen) {
			return this.id==((Pen)o).id;
		}
		return false;
	}
	public Pen(int id) {
		super();
		this.id = id;
	}
	
	
	

}
