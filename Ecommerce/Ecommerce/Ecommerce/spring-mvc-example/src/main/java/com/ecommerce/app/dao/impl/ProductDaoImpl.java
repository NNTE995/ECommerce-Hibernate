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
	
	/*@Override
	public void saveProduct(Product product){
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		//product.setProductId(1);
		product.setProductName("Samsung S21");
		product.setCategory("mobile phone");
		product.setPrice(800);
		product.setProductQuantity(22);
		
		session1.save(product);
		session1.getTransaction().commit();
		session1.close();
		
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		//product.setProductId(2);
		product.setProductName("Smart tv");
		product.setCategory("tv");
		product.setPrice(500);
		product.setProductQuantity(32);
		
		session2.save(product);
		session2.getTransaction().commit();
		session2.close();
		
		Session session3 = sessionFactory.openSession();
		session3.beginTransaction();
		//product.setProductId(3);
		product.setProductName("Refrigerator");
		product.setCategory("home");
		product.setPrice(550);
		product.setProductQuantity(34);
		
		session3.save(product);
		session3.getTransaction().commit();
		session3.close();
		
		Session session4 = sessionFactory.openSession();
		session4.beginTransaction();
		//product.setProductId(4);
		product.setProductName("Laptop");
		product.setCategory("office");
		product.setPrice(1100);
		product.setProductQuantity(25);
		
		session4.save(product);
		session4.getTransaction().commit();
		session4.close();
		
		System.out.println(product.getProductName() + " product saved");
	}*/
	
	@Override
	public List<Product> getProducts() {
		//List<Product> productsList = new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product>productsList =session.createQuery("FROM Product").getResultList(); 
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Products queried from database");
		return productsList;
	}
	
	/*@Override
	public void deleteProduct(Product p) {
		// TODO Auto-generated method stub
		for(Product pro : productsList) {
			if(pro.equals(p)) {
				if(pro.getProductQuantity() == 1)
					productsList.remove(pro);
				else
					pro.setProductQuantity(pro.getProductQuantity()-p.getProductQuantity());
			}
		}		
	}*/
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