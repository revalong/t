package com.fmt;

public class Product extends Item implements Invoiceable{
	//class to create product objects and calculate their taxes and total cost
	private String code;
	private double unitPrice;
	private String name;
	private String unit;
	private double quantity;
	

	public Product(String code,  String name, String unit, String unitPrice, Double quantity) {
		super(code,name,unit,Double.parseDouble(unitPrice),"P");
		this.name=name;
		this.unit=unit;
		this.code=code;
		this.unitPrice=Double.parseDouble(unitPrice); 
		this.quantity=quantity;

	
	}
	

	public double getSubTotalPay() {
		return unitPrice* quantity;
	}
	public double getTotalPay() {
		return getSubTotalPay()-getTaxes();
	}
	
	public double getTaxes() {
		//calculates taxes
		return 0.0715*getSubTotalPay();
	}


	public String getCode() {
		return code;
	}


	public String getUnit() {
		return unit;
	}


	
	public double getTotal() {
		//calculates total cost
		return getSubTotalPay()+getTaxes();
	}


	public String getName() {
		return name;
	}
	public double getQuantity() {
		return quantity;
	}
	
	

}