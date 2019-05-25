package com.shoppingbasket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingbasket.dao.ItemDao;
import com.shoppingbasket.model.Item;

@Service
public class ItemService 
{
	
	@Autowired
	private ItemDao itemDao;
	
	public List<Item> findAllItems() 
	{
		List<Item> items = new ArrayList<Item>();
		itemDao.findAll().forEach(items::add);
		return items;
	}

	public Optional<Item> findById(int id) 
	{
		return itemDao.findById(id);
	}

	public void saveItem(Item newItem) 
	{
		itemDao.save(newItem);
	}

	public void updateItem(Item existing, int id) 
	{
		itemDao.save(existing);
	}

	public void deleteItem(int id) 
	{
		itemDao.deleteById(id);
	}
}
