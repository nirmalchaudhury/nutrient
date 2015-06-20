package com.nirmalsprojects.nutrient.module.shoppingcart;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.nirmalsprojects.nutrient.types.UserItem;


public interface IShoppingCartModule {
	
	/**
	 * Register a shopping cart listener to be notified of a shopping cart event
	 * 
	 * @param listener listener to be notified
	 */
	void addListener(IShoppingCartListener listener);
	
	/**
	 * Gets the user item that are currently in the shopping cart
	 * 
	 * @param userId user id of the item
	 * @return items of the user
	 */
	ArrayList<UserItem> getItems(int userId);

	/**
	 * Checks if the user item is in the shopping cart
	 * 
	 * @param userId user id of the item
	 * @param itemName name of the item
	 * @return true if the item is in the cart, false otherwise
	 */
	boolean isItemInShoppingCart(int userId, String itemName);
	
	/**
	 * It marks the item as removed if it's already in the shopping cart and adds a new instance
	 * of the item
	 * 
	 * @param userId user id of the item
	 * @param itemName name of the item
	 * @param quantity item quantity
	 * @return true if the item was added, false otherwise
	 */
	boolean addItem(int userId, String itemName, int quantity);
	
	/**
	 * It marks the item as removed if it's already in the shopping cart and adds a new instance
	 * of the item on a specific date
	 * 
	 * @param userId user id of the item
	 * @param itemName name of the item
	 * @param quantity item quantity
	 * @param date date to be added
	 * @return true if the item was added, false otherwise
	 */
	boolean addItem(int userId, String itemName, int quantity, DateTime date);
	
	/**
	 * Removes the item if it is in the cart. If the item was bought it will mark the item as removed,
	 * otherwise it will delete the item from the data store.
	 * 
	 * @param userId user id of the item
	 * @param itemName name of the item
	 * @param isBought flag to indicate if the item was bought
	 * @return true if the item was removed
	 */
	boolean removeItem(int userId, String itemName, boolean isBought);
}
