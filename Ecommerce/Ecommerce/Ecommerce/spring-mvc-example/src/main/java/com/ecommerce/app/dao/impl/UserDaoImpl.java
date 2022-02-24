package com.ecommerce.app.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.UserDao;
import com.ecommerce.app.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(User user) {
		//userDatabase.put(user.getName(), user);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(user.getName() + " details saved");
	}

	@Override
	public User authenticateUser(String name, String password) {
		User u = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		u =(User) session.createQuery("FROM User WHERE name = '"+name+"'").uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(u == null) //caso: usuario no registrado
			return null;
		if (! (u.getPassword().equals(password))) { //caso usuario con contraseña inválida
			User dummy = new User();
			dummy.setName(name);
			dummy.setPassword(null);
			return dummy;	
			}	
		return u;
	}
}