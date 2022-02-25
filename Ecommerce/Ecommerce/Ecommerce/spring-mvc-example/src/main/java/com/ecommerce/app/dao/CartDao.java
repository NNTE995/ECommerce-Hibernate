package com.ecommerce.app.dao;

import java.util.List;

import com.ecommerce.app.entity.Product;

public interface CartDao {

	public List<Product> getProducts();
	
	public void addProduct(Product product);
	
	public double getTotal();
	
	public void clearCart();
}