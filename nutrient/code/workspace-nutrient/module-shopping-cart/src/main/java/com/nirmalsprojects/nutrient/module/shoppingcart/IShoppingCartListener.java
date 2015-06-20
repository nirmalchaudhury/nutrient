package com.nirmalsprojects.nutrient.module.shoppingcart;

import com.nirmalsprojects.nutrient.types.UserItem;

/**
 * Classes that are interested in the shopping cart events should implement
 * this interface and register itself with the shopping cart module.
 * 
 * @author Nirmal
 *
 */
public interface IShoppingCartListener {
	
	/**
	 * Callback function when an item is added to the shopping cart
	 * 
	 * @param item item added
	 */
	void onNewShoppingCartItem(UserItem item);
	
	/**
	 * Callback function when an item is bought
	 * 
	 * @param item bought item
	 */
	void onBoughtShoppingCartItem(UserItem item);

}
