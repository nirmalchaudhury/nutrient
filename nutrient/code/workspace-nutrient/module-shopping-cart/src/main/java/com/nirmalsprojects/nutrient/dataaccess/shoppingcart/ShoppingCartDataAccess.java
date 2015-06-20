package com.nirmalsprojects.nutrient.dataaccess.shoppingcart;

import com.nirmalsprojects.nutrient.dataaccess.common.UserItemDataAccess;

public class ShoppingCartDataAccess extends UserItemDataAccess implements IShoppingCartDataAccess {
	
	public void initialize() {
		// Do Nothing
	}

	public boolean connect() {
		return true;
	}

	public boolean disconnect() {
		return true;
	}

}
