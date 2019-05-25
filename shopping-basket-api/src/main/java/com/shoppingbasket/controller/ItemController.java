package com.shoppingbasket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingbasket.model.Item;
import com.shoppingbasket.service.ItemService;

@RestController
public class ItemController 
{
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/items")
	public List<Item> getAllTopics()
	{
		return itemService.findAllItems();
	}
	
	@RequestMapping("/items/{id}")
	public Optional<Item> getTopic(@PathVariable int id)
	{
		return itemService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/items")
	public void addTopic(@RequestBody Item newItem)
	{
		itemService.saveItem(newItem);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/items/{id}")
	public void updateTopic(@RequestBody Item existing, @PathVariable int id)
	{
		itemService.updateItem(existing, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/items/{id}")
	public void deleteTopic(@PathVariable int id)
	{
		itemService.deleteItem(id);
	}
}
