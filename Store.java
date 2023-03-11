package com.fmt;

public class Store{
	//class to create store objects
	private String code;
	private Person manager;
	private Address address;
	private String managerCodeStore;
	private double total;
	//class to create stores objects
	
	public Store(String code, String managerCode, String street, String city, String state, String zip,
			String country) {
		this.code = code;
		this.manager =new Person(managerCode);
		this.setAddress(new Address(street,city,state,zip,country));
		total=0;
	}

	


	public Store(String code, String managerCodeStore, String street, String city, String state, String zip,
			String country, Person person) {
		this.code=code;
		this.managerCodeStore = managerCodeStore;
		this.setAddress(new Address(street,city,state,zip,country));
		this.manager = person;
	}
	public Store() {
		code= "    ";
	}
	public String getCode() {
		return code;
	}
	
	
	
	public String toString() {
		return code + "\t\t" + manager + "\t\t";
		
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}



	public Person getManager() {
		return manager;
	}




	public String getManagerCodeStore() {
		return managerCodeStore;
	}
	
}