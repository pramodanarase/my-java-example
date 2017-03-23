package org.jpa.hibernate;

import java.util.List;

import javax.persistence.EntityManager;

import myjava.example.jpa.model.User;
import myjava.example.jpa.service.JPAUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
	    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	    addUser(entityManager);
	    entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	    getUsers(entityManager);
	    
	    JPAUtil.shutdown();
	    
	    
	    
	}

	private static void getUsers(EntityManager entityManager) {
		entityManager.getTransaction().begin();
	    
	    List<User> userList =
	    		entityManager.createQuery("select u from User u").getResultList();
	    
	    for(User user : userList){
	    	System.out.println(user.toString());
	    }
	    
	    entityManager.getTransaction().commit();
	    entityManager.close();
	}

	private static void addUser(EntityManager entityManager) {
		entityManager.getTransaction().begin();

	    User user = new User();
	    user.setUsername("pramod");
	    user.setEmail("test@email.com");
	    user.setMobileNumber(123456789);
	    
	    entityManager.persist(user);
	    
	    entityManager.getTransaction().commit();
	    entityManager.close();
	}

}
