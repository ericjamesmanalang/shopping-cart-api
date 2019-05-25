package com.shoppingbasket.dao;

import org.springframework.data.repository.CrudRepository;

import com.shoppingbasket.model.Item;

public interface ItemDao extends CrudRepository<Item, Integer>
{
	
}
