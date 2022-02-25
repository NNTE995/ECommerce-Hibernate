package com.ecommerce.app.dao.impl;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.ProductDao;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.ProductService;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	public List<Product> productsList = new ArrayList<>();
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product>productsList =session.createQuery("FROM Product").getResultList(); 
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Products queried from database");
		return productsList;
	}
	
	@Override
	public void deleteProduct(int productId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(session.get(Product.class, productId));
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void deleteProduct(Product p) {
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> getProductByName(String name) {

		//List<Product> products = new ArrayList<>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//products = session.createSQLQuery("SELECT * FROM product WHERE productName LIKE ?1").setString(1, name).list();
		String QuerryPFN="FROM Product WHERE productName='"+name+"'";
		List<Product>productsList=session.createQuery(QuerryPFN).getResultList(); 
		session.getTransaction().commit();
		session.close();
		return productsList;
	}
}