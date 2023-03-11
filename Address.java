package com.fmt;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	//class to create address objects
	
	public Address(String street, String city, String state, String zip, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}


//toString to print out addresses
	public String getAddress() {
		return street + "\n" + city + " " + state + " " + zip + " " + country;
		
	}
	
	
	
}
