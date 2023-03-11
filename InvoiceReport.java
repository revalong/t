package com.fmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class InvoiceReport extends DataConverter{
	//class to read invoices.csv and invoiceItems.csv and create reports
private static ArrayList<Store> st;
private static ArrayList<Item> it;
private static ArrayList<Person> per;
private static ArrayList<Invoice> invoice;
private static ArrayList<InvoiceItem> invoiceItem;
private static ArrayList<InvoiceItem> allInvoiceItem;

	
	

		
public static void main(String[] args) throws FileNotFoundException {
	reportFiles();
	//report #1 prints all of the invoices and their totals
	System.out.println("+-----------------------------------------------------------------------------------+\n| Summary Report                                                                    |\n+-----------------------------------------------------------------------------------+");
	System.out.println("Sale\t\tStore\t\tCustomer\t\tSalesperson\t\tTotal");
	for(int i =0; i<invoice.size();i++) {
		System.out.println(invoice.get(i));
	}
	//report #2 loops through the stores and counts the invoice items for each store and the total 
	System.out.println("+-----------------------------------------------------------------------------------+\n| Store Sales Summary                                                                    |\n+-----------------------------------------------------------------------------------+");
	System.out.println("Store\t\tManager\t\t\t\t# sales\t\tGrand Total");
	for(int i =0; i<st.size();i++) {
		System.out.print(st.get(i));
		int count=0;
		double amount=0;
		for(int j =0; j<invoice.size();j++) {
			if(invoice.get(j).getStoreCode().equals(st.get(i).getCode())){
				count+=invoice.get(j).getIt().size();
				amount+=invoice.get(j).getInvoiceTotal();
			}
	}
	
		System.out.println("\t" + count + "\t\t" + amount);
	}
	// report #3 prints information on all of the invoices and their items
	for(int i =0; i<invoice.size();i++) {
		System.out.println("----------------------------------------------------------------------------------------");
		invoice.get(i).getInfo();
	}
}
				
				
			public static void reportFiles() throws FileNotFoundException{
				// function to read the files and create arraylists for the invoices and invoiceitems
				int n;
				String type= null;
				st = DataConverter.addStore();
				it= DataConverter.addItem();
				per = DataConverter.addPeople();
				invoice = new ArrayList<Invoice>();
				allInvoiceItem = new ArrayList<InvoiceItem>();
				
				Item q= null;
				try (Scanner p = new Scanner(new File("data/InvoiceItems.csv"))) {
					//reads invoice items and cretes InvoiceItem objects based on their type
				n = Integer.parseInt(p.nextLine());
					for(int i =0;i<n;i++) {
						String line=p.nextLine();
						String[] t = line.split(",");
				for(int b=0;b<it.size();b++) {
					if(it.get(b).getCode().equals(t[1])) {
						q=it.get(b);
						type=it.get(b).getType();
					}							
				}
				if(type !=null) {
					if(type.equals("Product")){
						allInvoiceItem.add(new InvoiceItem(t[0],q, t[2],new Product(t[0],q.getName(),q.getUnit(),t[2], Double.parseDouble(t[2]))));
				}}
				if(type !=null) {
					if(type.equals("Equipment")){
						if(t[2].equals("P")) {
							allInvoiceItem.add(new InvoiceItem(t[0], q,t[2],new Purchase(t[1],Double.parseDouble(t[3]),q.getName(),q.getModel())));
						}
						if(t[2].equals("L")) {
							
							allInvoiceItem.add(new InvoiceItem(t[0], q,t[2],t[3],new Lease(t[1],Double.parseDouble(t[3]),t[4],t[5],q.getName(),q.getModel())));
				}}}
				if(type !=null) {
				if(type.equals("S")){
					allInvoiceItem.add(new InvoiceItem(t[0],q,t[2],new Service(t[0],q.getType(),q.getName(),q.getHourlyRate(),Double.parseDouble(t[2]))));
				}}
				}
				}
		
			
					try (Scanner v = new Scanner(new File("data/Invoices.csv"))) {
						//reads invoices and adds invocie objects to invoiceItem
						n = Integer.parseInt(v.nextLine());
						for(int m =0;m<n;m++) {
							String l =v.nextLine();
							String[] tokens = l.split(",");
							invoiceItem = new ArrayList<InvoiceItem>();
							Store c = new Store();
							Person customer = null;
							Person salesPerson = null;
							for(int j = 0;j<st.size();j++) {
								if(st.get(j).getCode().equals(tokens[1]))
									c=st.get(j);
						}
							for(int k =0; k<per.size();k++) {
								if(per.get(k).getCode().equals(tokens[2])) 
									customer = per.get(k);
								if(per.get(k).getCode().equals(tokens[3]))
									salesPerson = per.get(k);
								}
						
							for(int z = 0;z<allInvoiceItem.size();z++) {
								if(allInvoiceItem.get(z).getInvoiceCode1().equals(tokens[0])) 
								invoiceItem.add(allInvoiceItem.get(z));
								
							}
							invoice.add(new Invoice(tokens[0], c, customer, salesPerson,tokens[4],invoiceItem));
						}
					}catch (NumberFormatException e) {
						
						e.printStackTrace();
					
					}
				}
			
}
	
			
				
			
				
		





		
	
		