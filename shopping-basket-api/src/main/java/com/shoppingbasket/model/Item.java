package com.shoppingbasket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item 
{
	@Id
	@GeneratedValue
	private int id;
	
	private String category;
	
	private String name;
	
	private String description;
	
	private double price;
	
	public Item()
	{
		
	}

	public Item(int id, String category, String name, String description, double price) 
	{
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCategory() 
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

}
