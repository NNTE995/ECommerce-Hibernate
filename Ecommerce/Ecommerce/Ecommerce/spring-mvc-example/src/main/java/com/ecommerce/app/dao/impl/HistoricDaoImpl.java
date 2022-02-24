package com.ecommerce.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.HistoricDao;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.Purchase;
import com.ecommerce.app.entity.User;

@Repository
public class HistoricDaoImpl implements HistoricDao{

	//List<Purchase> purchases = new ArrayList<>();
	List<Cart> purchases = new ArrayList<>();
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Cart> getHistoric() {
		return purchases;
	}

	@Override
	public void addPurchase(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cart);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public List<Cart> getHistoric(Integer userId) {
		List<Cart> purchaseByUser = new ArrayList<>();		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		purchaseByUser = session.createQuery("FROM Cart WHERE id=2").list();
		
		session.getTransaction().commit();
		session.close();
		
	System.out.print("Purchases"+ purchaseByUser);
		return purchaseByUser;
	}
}