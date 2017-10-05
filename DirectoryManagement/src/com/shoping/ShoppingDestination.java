package com.shoping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class ShoppingDestination {
	Map<Integer, Product> items = new HashMap();
	Map<Integer, Product> itemsPicked = new HashMap();
	
	
	ShoppingDestination(){
		items.put(1, new Product("Bovonto", 35, 160));
		items.put(2, new Product("Soda", 20, 87));
		items.put(3, new Product("paneer", 20, 879));
		

	}
	
	public void showProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\nThe prodicts available");
		Set s1 = items.entrySet();
		Iterator iter = s1.iterator();
		System.out.println("**********************************************************");
		System.out.println("Product id\tProduct Name\tProduct cost\tProduct quantity");
		while(iter.hasNext()){
			Map.Entry<Integer, Product> me = (Map.Entry)iter.next();
			System.out.println(me.getKey()+"\t\t"+me.getValue().getProductName()+"\t\t"+me.getValue().getProductPrice()+"\t\t"+me.getValue().ProductQuantity);
		}
		System.out.println("**********************************************************");
		System.out.print("Choose the produt id ");
		while(!sc.hasNextInt()) {System.out.print("Enter vaid option :");sc.next();}
		int option = sc.nextInt();
		
		if(items.containsKey(option)) {
			
			Product b = items.get(option);
			
			System.out.println("\n\n\nThe product choosed");
			System.out.println("*********************************************************");
			System.out.println("Product Name\t Product cost\t Product quantity");	
			System.out.println(b.getProductName()+"\t\t"+b.getProductPrice()+"\t\t"+b.getProductQuantity());
			System.out.print("Enter the quantity :");
			while(!sc.hasNextInt()) {System.out.print("Enter vaid option :");sc.next();}
			int quan = sc.nextInt();
			if(quan>b.getProductQuantity()) {
				System.out.println("\n\n\nThe quantity you entered is not availble in stock");
				System.out.println("*********************************************************");
				System.out.print("Please enter less quantity");
				showProduct();
			}
			else {
				int ch;
				b.setProductQuantity((b.getProductQuantity()-quan));
				if(itemsPicked.containsKey(option)) {
					
				quan += itemsPicked.get(option).getProductQuantity();
				itemsPicked.put(option, new Product(b.getProductName(),quan*b.getProductPrice(),quan));
				}
				else {
					itemsPicked.put(option, new Product(b.getProductName(),quan*b.getProductPrice(),quan));
				}
				System.out.println("*********************************************************");
				System.out.println("Added to your cart successfully\n");
				System.out.println("*********************************************************");
				
				System.out.print("continue shopping? ( \"1\" = yes or any other number = no)");
				while(!sc.hasNextInt()) {System.out.print("Enter vaid option :");sc.next();}
				
				
				ch=sc.nextInt();
				if(ch==1) {
					showProduct();
				}
				
			}
		}
		else {
			System.out.println("\n\n\nYou have entered the wrong product id");
			showProduct();
		}
	}
	
	public void showOrder() {
		if(itemsPicked.isEmpty()) {
			System.out.println("\n\n\n");
			System.out.println("You have not yet purchased");
		}
		else {
			Set s1 = itemsPicked.entrySet();
			Iterator iter = s1.iterator();
			int total = 0;
			System.out.println("\n\n\n");
			System.out.println("**********************************************************");
			System.out.println(" Product Name\t Product cost\t Product quantity");
			System.out.println("**********************************************************");
			while(iter.hasNext()){
				Map.Entry<Integer, Product> me = (Map.Entry)iter.next();
				System.out.println(me.getValue().getProductName()+"\t\t"+me.getValue().getProductPrice()+"\t\t"+me.getValue().ProductQuantity);
				total += me.getValue().getProductPrice();
			}
			System.out.println("\t******** Total Cost :"+total+" *********");
		}
	}
	
	public static void main(String[] ags) throws InputMismatchException {
		ShoppingDestination  sd = new ShoppingDestination();
		int input =0;
		
		do {
		System.out.println("\n\n\n\n**********************************************************");
		System.out.println("The shopping cart");
		System.out.println("**********************************************************");
		Scanner sc = new Scanner(System.in);
		System.out.println("1. choose the product");
		System.out.println("2. Your Order");
		System.out.println("3. Exit");
		System.out.print("Please enter the option :");
		while (!sc.hasNextInt())
		{System.out.print("Enter vaid option :");
		sc.next();}
	    input = sc.nextInt();
		
		
		
		
			switch(input) {
			case 1:
				sd.showProduct();
				break;
			case 2:
				sd.showOrder();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("enter vaild number");
				
			}	
		}while(input!=3);
		
	}
}
