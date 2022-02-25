package com.ecommerce.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.app.entity.Product;

@Service
public interface ProductService {

	//void saveProduct(Product product);
	List<Product> getProductsList();
	public List<Product> getProductByName(String name);
	void deleteProduct(int productId);
}