package com.jacektracz.java8.streams.grouping;


public class LakidaFinancialInstrument {
	private String name;
	private String type;
	private double price;
	public LakidaFinancialInstrument(String name, String type, double price) {
		setName(name);
		setType(type);
		setPrice(price);
	}	
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name=name;
	}
	public String getType() {
		return type;
	}
	public void setType (String type) {
		this.type=type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice (double price) {
		this.price=price;
	}
	public String toString() {
		return name + " is a " + type + " instrument that costs " + price + " dollars";
	}	
}		
	