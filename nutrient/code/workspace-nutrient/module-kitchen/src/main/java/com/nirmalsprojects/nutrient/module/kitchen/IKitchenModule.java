package com.nirmalsprojects.nutrient.module.kitchen;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.types.UserItem;

/**
 * Interface to the kitchen module
 * @author Nirmal
 *
 */
public interface IKitchenModule {
	
	/**
	 * Add listener to the kitchen module. The listener will be notified
	 * of kitchen events
	 * 
	 * @param listener listener to be notify
	 */
	void addListener(IKitchenListener listener);
	
	/**
	 * Gets items in the kitchen
	 * 
	 * @param userId user id of the entries
	 * @return entries that belong to a specific user
	 */
	ArrayList<UserItem> getItems(int userId);
	
	/**
	 * Gets all the kitchen items associated with a specific user Id and itemName
	 * 
	 * @param userId userId of interest
	 * @param itemName itemName of interest
	 * @return list of user item entries
	 */
	ArrayList<UserItem> getItems(int userId, String itemName);
	
	/**
	 * Checks to see if an item of a specific user id and item name is in the kitchen
	 * 
	 * @param userId userId of interest
	 * @param itemName itemName of interest
	 * @return true if the item is in the kitchen, false otherwise
	 */
	boolean isItemInKitchen(int userId, String itemName);
	
	/**
	 * Adds the item to the kitchen. If the item is already in the kitchen the newly added item will
	 * override the one that is currently there.
	 * 
	 * @param userId userId of the item
	 * @param itemName name of the item
	 * @param quantity item quantity
	 * @return true if the item was added, false otherwise
	 */
	boolean addItem(int userId, String itemName, int quantity);
	
	/**
	 * Removes the item from the kitchen
	 * 
	 * @param userId user id of the entry to remove
	 * @param itemName itemName of the entry to remove
	 * @return true if the item is removed, false otherwise
	 */
	boolean removeItem(int userId, String itemName);

}
