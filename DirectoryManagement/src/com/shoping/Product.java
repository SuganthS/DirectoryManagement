package com.shoping;

public class Product {
	
	String productName;
	int productPrice, ProductQuantity;
	
	Product(String name, int price, int quantity){
		this.productName = name;
		this.productPrice = price;
		this.ProductQuantity = quantity;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	
	
}
