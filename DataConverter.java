package com.fmt;

import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


//takes in csv files, creates objects of the data and exports the objects to json files

		public class DataConverter {
		private static ArrayList<Item> it;
		private static ArrayList<Person> per;
		public static ArrayList<Store> st;
		
		
	
		
			public static  void main(String[] args) throws FileNotFoundException {
				//sets it to an arraylist of items, st to an arraylist of stores, and per to an arraylist of people
				it=addItem();
				st=addStore();
				per = addPeople();
				printGson();
				//outputs it st and per to json files
				
			}
			public static ArrayList<Item> addItem() throws FileNotFoundException{
				//function to read the items.csv files create items objects and add them to an arraylist
				it = new ArrayList<Item>();
				int n = 0;
				Scanner s = new Scanner(new File("data/Items.csv"));
				n = Integer.parseInt(s.nextLine());
				for(int i =0;i<n;i++) {
					String line = s.nextLine();
					String tokens[] = line.split(",");
					if(tokens[1].equals("E")) {
						//adds a new equipment objects if the token is an E
						it.add(new Equipment(tokens[0],tokens[1],tokens[2],tokens[3]));
					}
					else if(tokens[1].equals("P")) {
						//adds a new product object if the token is a p
						it.add(new Product(tokens[0],tokens[2],tokens[3],tokens[4],0.0));
					}
					else {
						//adds a new service object if the token is not e or p
						it.add(new Service(tokens[0],tokens[1],tokens[2],Double.parseDouble(tokens[3]),0));
						
					}
			}s.close();
				return it;
				}
			public static ArrayList<Store> addStore() throws FileNotFoundException{
				//function to read the stores.csv file and create store objects then add them to the st arraylist
				st = new ArrayList<Store>();
				per = addPeople();
				int n = 0;
				Scanner s = new Scanner(new File("data/Stores.csv"));
				n = Integer.parseInt(s.nextLine());
				for(int i =0;i<n;i++) {
					String line = s.nextLine();
					String tokens[] = line.split(",");	
					int j = -1;
					//Iterates through person list to check when manager codes are equal,
					//so that correct manager is linked to correct store
					for(Person person :per) {
						j+=1;
						if(person.getCode().equals(tokens[1])) {
							st.add(new Store(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6], per.get(j)));

					}
					}
				}
			
				return st;	
				}
			
		public static ArrayList<Person> addPeople() throws FileNotFoundException{
			//function to read the persons.csv file and then create people objects and add them to the per arraylist
			per = new ArrayList<Person>();
			int n = 0;
			
			Scanner s = new Scanner(new File("data/Persons.csv"));
			n = Integer.parseInt(s.nextLine());
			for(int i =0;i<n;i++) {
				String line = s.nextLine();
				String tokens[] = line.split(",");
				ArrayList<String> emails = new ArrayList<String>();					
				int numEmails = tokens.length;
				numEmails = tokens.length - 8;
				int x = 0;
				while(x<numEmails) {
					emails.add(tokens[x+8]);
					x+=1;
				}
				per.add(new Person(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],emails));
			}
			s.close();
			return per;
		}
			
		
		public static void printGson() {
		//function to print the arraylists to json files
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String[] jsonFiles = new String[3];
		jsonFiles[0] = gson.toJson(it);     
		jsonFiles[1] = gson.toJson(per);
		jsonFiles[2] = gson.toJson(st);
		
		for (int i = 0; i < 3; i++) {
			try
			{
			    String[] filenames= new String[3];
			    filenames[0] = "data/Items.json";
				filenames[1] = "data/Persons.json";
				filenames[2] = "data/Stores.json";
			    FileWriter fw = new FileWriter(filenames[i],true); //the true will append the new data
			    fw.write(jsonFiles[i]);//appends the string to the file
			    fw.close();
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
		}
		}
		
		}
