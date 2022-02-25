package com.ecommerce.app.dao;

import java.util.List;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;


public interface ProductDao {

	//void saveProduct(Product product);
	List<Product> getProducts();
	void deleteProduct(Product p);
	public List<Product> getProductByName(String name);
	void deleteProduct(int productId);
}