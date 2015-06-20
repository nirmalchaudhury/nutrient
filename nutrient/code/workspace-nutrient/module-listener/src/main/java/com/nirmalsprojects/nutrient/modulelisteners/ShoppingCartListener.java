package com.nirmalsprojects.nutrient.modulelisteners;

import com.nirmalsprojects.nutrient.module.common.ModuleType;
import com.nirmalsprojects.nutrient.module.common.Modules;
import com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartListener;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;
import com.nirmalsprojects.nutrient.types.UserItem;

public class ShoppingCartListener implements IShoppingCartListener {
	
	private IShoppingCartModule shoppingCart;
	
	private IKitchenModule kitchen;
	
	public ShoppingCartListener(Modules modules) {
		shoppingCart = (IShoppingCartModule) modules.getModule(ModuleType.SHOPPING_CART);
		kitchen = (IKitchenModule) modules.getModule(ModuleType.KITCHEN);
	}
	
	/**
	 * Registers with the shopping cart module
	 */
	public void register() {
		if (shoppingCart != null) {
			shoppingCart.addListener(this);
		}
	}

	public void onNewShoppingCartItem(UserItem item) {
		// Do Nothing
	}

	/**
	 * Adds the item to the kitchen when an item is bought
	 */
	public void onBoughtShoppingCartItem(UserItem item) {
		kitchen.addItem(item.userId, item.itemName, item.quantity);	
	}

}
