package com.fmt;

public class InvoiceItem extends Item{
	//class to create invoice item objects
	private String invoiceCode;
	private Item i;
	private String s;
	private String date1;
	private String date2;
	private Lease l;
	private Purchase p;
	private Service service;
	private Product product;

	
	public String getInvoiceCode() {
		return invoiceCode;
	}
	
	public InvoiceItem(String invoiceCode, Item i, String s) {
		super(invoiceCode,s);
		this.invoiceCode=invoiceCode;
		this.i=i;
		this.s=s;
	
	}
	//constructor for purchases
	public InvoiceItem(String invoiceCode, Item i, String s,Purchase p) {
		super(invoiceCode,s);
		this.invoiceCode=invoiceCode;
		this.i=i;
		this.s=s;
		this.p=p;
	}
	//constructor for products
	public InvoiceItem(String invoiceCode, Item i, String s,Product product) {
		super(invoiceCode,s);
		this.invoiceCode=invoiceCode;
		this.i=i;
		this.s=s;
		this.product=product;
	}
//constructor for leases
	public InvoiceItem(String invoiceCode, Item q, String date1, String date2,Lease l) {
		super(invoiceCode);
		this.invoiceCode=invoiceCode;
		this.i=q;
		this.date1=date1;
		this.date2=date2;
		this.l=l;
		
	}
	//constructor for services
	public InvoiceItem(String invoiceCode, Item i, String s,Service service) {
		super(invoiceCode,s);
		this.invoiceCode=invoiceCode;
		this.i=i;
		this.s=s;
		this.service=service;
	}
	public String getInvoiceCode1() {
		return invoiceCode;
	}
	public Item getI() {
		return i;
	}

	public String getDate1() {
		return date1;
	}

	public String getDate2() {
		return date2;
	}
	public double getTotal() {
		return 0;
	}

	public String toString() {
		return invoiceCode;
		}
	public String getName() {
		return super.getName();
	}


	public Lease getL() {
		return l;
	}

	public Purchase getP() {
		return p;
	}

	public Service getService() {
		return service;
	}

	public Product getProduct() {
		return product;
	}


	

	
}
