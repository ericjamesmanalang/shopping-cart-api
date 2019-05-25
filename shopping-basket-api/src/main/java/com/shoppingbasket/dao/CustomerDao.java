package com.shoppingbasket.dao;

import org.springframework.data.repository.CrudRepository;

import com.shoppingbasket.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer>
{
	
}
