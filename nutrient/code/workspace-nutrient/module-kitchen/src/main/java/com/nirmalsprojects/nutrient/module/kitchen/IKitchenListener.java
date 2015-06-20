package com.nirmalsprojects.nutrient.module.kitchen;

import com.nirmalsprojects.nutrient.types.UserItem;

/**
 * Interface to kitchen module alerts.
 * 
 * @author Nirmal
 *
 */
public interface IKitchenListener {
	
	/**
	 * Method invoked when a new item is added to the kitchen
	 * 
	 * @param item item added
	 */
	void onNewKitchenItem(UserItem item);
	
	/**
	 * Method invoked when an item is removed from the kitchen
	 * 
	 * @param item item removed
	 */
	void onRemovedKitchenItem(UserItem item);
	
}
