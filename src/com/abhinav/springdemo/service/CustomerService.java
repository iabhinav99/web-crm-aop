package com.abhinav.springdemo.service;

import java.util.List;

import com.abhinav.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	
}
