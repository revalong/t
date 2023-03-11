package com.fmt;

public class Service extends Item implements Invoiceable{
	//class to create service objects adn calculate their total and taxes
	private String code;
	private transient String type;
	private String name;
	private double hourlyRate;
	private double hours;
	
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public Service(String code, String type, String name, double hourlyRate, double hours) {
		super(code,type,name,hourlyRate, "S");
		this.code=code;
		this.type=type;
		this.name=name;
		this.hourlyRate=hourlyRate;
		this.hours=hours;
			}
	
	public double getTaxes() {
		//calculates the taxes 
		return hourlyRate * hours *.0345;
	}



	public double getSubTotalPay() {
		return hourlyRate* hours;
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	public double getTotal() {
		//calcualtes the total
		return getSubTotalPay()+getTaxes();
	}
	

}