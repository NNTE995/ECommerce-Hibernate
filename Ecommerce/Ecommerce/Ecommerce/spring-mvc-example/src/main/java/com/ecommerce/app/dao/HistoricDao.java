package com.ecommerce.app.dao;

import java.util.List;

import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Purchase;

public interface HistoricDao {

	public List<Cart> getHistoric();
	
	public void addPurchase(Cart cart);
	
	public List<Cart> getHistoric(Integer userId);
}