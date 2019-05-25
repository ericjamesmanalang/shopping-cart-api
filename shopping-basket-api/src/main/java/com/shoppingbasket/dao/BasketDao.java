package com.shoppingbasket.dao;

import org.springframework.data.repository.CrudRepository;

import com.shoppingbasket.model.Basket;

public interface BasketDao extends CrudRepository<Basket, Integer>
{
	
}
