package com.ecommerce.app.entity;

import java.util.List;

public class Historic {
	List<Cart> purchases;

	public List<Cart> getPurchases() {
		return purchases;
	}
	
	public void setPurchases(List<Cart> purchases) {
		this.purchases = purchases;
	}
}