package com.ecommerce.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private Integer productId;
	private String productName;
	private String category;
	private double price;
	private double productQuantity;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	/*@Override
	public boolean equals(Object o) {
		Product p = (Product)o;
		return (this.productId == p.productId)? true : false;	
	}*/	
}