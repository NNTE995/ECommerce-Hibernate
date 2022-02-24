package com.ecommerce.app.entity;

import java.util.List;

import javax.persistence.Entity;

//@Entity
public class Historic {
	//List<Purchase> purchases;
	List<Cart> purchases;

	public List<Cart> getPurchases() {
		return purchases;
	}
	/*public List<Purchase> getPurchases() {
		return purchases;
	}*/

	/*public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}*/
	public void setPurchases(List<Cart> purchases) {
		this.purchases = purchases;
	}
}