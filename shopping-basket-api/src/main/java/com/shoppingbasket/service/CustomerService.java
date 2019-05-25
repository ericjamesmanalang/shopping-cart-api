package com.shoppingbasket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingbasket.dao.CustomerDao;
import com.shoppingbasket.model.Customer;

public class CustomerService 
{
	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> findAllCustomer() 
	{
		List<Customer> customer = new ArrayList<Customer>();
		customerDao.findAll().forEach(customer::add);
		return customer;
	}

	public Optional<Customer> findById(int id) 
	{
		return customerDao.findById(id);
	}

	public void saveCustomer(Customer newCustomer) 
	{
		customerDao.save(newCustomer);
	}

	public void updateCustomer(Customer existing, int id) 
	{
		customerDao.save(existing);
	}

	public void deleteCustomer(int id) 
	{
		customerDao.deleteById(id);
	}
}
