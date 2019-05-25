package com.shoppingbasket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingbasket.dao.BasketDao;
import com.shoppingbasket.model.Basket;
import com.shoppingbasket.model.Item;

@Service
public class BasketService 
{
	
	@Autowired
	private BasketDao basketDao;
	
	public List<Basket> findAllItems() 
	{
		List<Basket> basket = new ArrayList<Basket>();
		basketDao.findAll().forEach(basket::add);
		return basket;
	}

	public Optional<Basket> findById(int id) 
	{
		return basketDao.findById(id);
	}

	public void saveBasket(Basket newBasket) 
	{
		basketDao.save(newBasket);
	}

	public void updateBasket(Basket existing, int id) 
	{
		basketDao.save(existing);
	}

	public void deleteBasket(int id) 
	{
		basketDao.deleteById(id);
	}
}
