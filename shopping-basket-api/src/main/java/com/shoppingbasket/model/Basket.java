package com.shoppingbasket.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Basket 
{
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Optional<Customer> customer;
	
	@OneToMany
	private List<Optional<Item>> items;
	
	public Basket()
	{
		
	}
	
	public Basket(int id, Optional<Customer> customer, List<Optional<Item>> items) 
	{
		super();
		this.id = id;
		this.customer = customer;
		this.items = items;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public Optional<Customer> getCustomer() 
	{
		return customer;
	}

	public void setCustomer(Optional<Customer> customer2) 
	{
		this.customer = customer2;
	}

	public List<Optional<Item>> getItems() 
	{
		return items;
	}

	public void setItem(List<Optional<Item>> item2) 
	{
		this.items = item2;
	}
	
}
