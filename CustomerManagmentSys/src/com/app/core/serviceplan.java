package com.app.core;

public enum serviceplan {
	SILVER (1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	
	private double charge;
	
	serviceplan(double d){
		charge=d;
	}
	@Override
	public String toString() {
		return name()+" : "+charge;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	
}
