package com.abhinav.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.abhinav.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Need to inject Session Factory
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		//get the current hibernate Session
		Session session=sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> query=session.createQuery("from Customer", Customer.class);
		
		//execute query and get result set
		List<Customer> CustomerList=query.getResultList();
		
		// return the result
		return CustomerList;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the current hibernate session
		
		Session session=sessionFactory.getCurrentSession();
		
		//Save the customer
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class, theId);
		session.delete(theCustomer);
		
	}
	

}
