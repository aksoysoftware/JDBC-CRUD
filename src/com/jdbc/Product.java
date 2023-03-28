package com.jdbc;

public class Product {
	private long productId;
	private String productName;
	private double salesPrice;
	
	
	
	
	
	public Product(long productId, String productName, double salesPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}
	public Product(String productName, double salesPrice) {
		super();
		this.productName = productName;
		this.salesPrice = salesPrice;
	}
	public Product() {
		super();
	}
	
	
	public long getId() {
		return productId;
	}
	public void setId(long id) {
		productId = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	

}
