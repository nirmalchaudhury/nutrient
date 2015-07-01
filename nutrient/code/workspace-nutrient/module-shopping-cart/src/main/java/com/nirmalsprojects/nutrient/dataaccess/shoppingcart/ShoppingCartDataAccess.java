package com.nirmalsprojects.nutrient.dataaccess.shoppingcart;

import com.nirmalsprojects.nutrient.dataaccess.common.UserItemDataAccess;

/**
 * Shopping cart data store. Data is not persisted after application is closed
 */
public class ShoppingCartDataAccess extends UserItemDataAccess implements IShoppingCartDataAccess {
	
	/**
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IDataAccess#initialize()
	 */
	public void initialize() {
		// Do Nothing
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IDataAccess#connect()
	 */
	public boolean connect() {
		return true;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IDataAccess#disconnect()
	 */
	public boolean disconnect() {
		return true;
	}

}
