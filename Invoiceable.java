package com.fmt;

public interface Invoiceable {
	//interface that is implemented in all of the bottom subclasses
	public double getTaxes();
	public double getTotal();

}
