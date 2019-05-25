package com.shoppingbasket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingbasket.model.Basket;
import com.shoppingbasket.model.Customer;
import com.shoppingbasket.model.Item;
import com.shoppingbasket.service.BasketService;
import com.shoppingbasket.service.CustomerService;
import com.shoppingbasket.service.ItemService;

@RestController
public class BasketController 
{
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="customer/{customerId}/baskets}")
	public void createBasket(@RequestBody Basket newBasket, @PathVariable int customerId)
	{
		Optional<Customer> customer = customerService.findById(customerId);
		newBasket.setCustomer(customer);
		basketService.saveBasket(newBasket);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="customer/{customerId}/baskets/{basketId}/items/{itemId}")
	public void addItemToBasket(@RequestBody Basket existingBasket, @PathVariable int customerId, int itemId)
	{
		Optional<Item> item = itemService.findById(itemId);
		existingBasket.getItems().add(item);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="customer/{customerId}/baskets/{basketId}/items/{itemId}")
	public void removeItemToBasket(@RequestBody Basket existingBasket, @PathVariable int customerId, int itemId)
	{
		Optional<Item> item = itemService.findById(itemId);
		existingBasket.getItems().remove(item);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="customer/{customerId}/baskets/{basketId}/items")
	public List<Optional<Item>> getAllItemsInBasket(@PathVariable int customerId, @PathVariable int basketId)
	{
		List<Optional<Item>> items = basketService.findById(basketId).get().getItems();
		return items;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="customer/{customerId}/baskets/{basketId}/items/total-price")
	public double getTotalPriceInBasket(@PathVariable int customerId, @PathVariable int basketId)
	{
		double total = 0;
		for( Optional<Item> i: basketService.findById(basketId).get().getItems())
		{
			total = total + i.get().getPrice();
		}
		return total;
	}
	
}
