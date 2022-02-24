package com.ecommerce.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Purchase;

@Service
public interface HistoricService {
	public List<Cart> getHistoric();
	
	public void addPurchase(Cart cart);
	
	public List<Cart> getHistoric(Integer userId);
}