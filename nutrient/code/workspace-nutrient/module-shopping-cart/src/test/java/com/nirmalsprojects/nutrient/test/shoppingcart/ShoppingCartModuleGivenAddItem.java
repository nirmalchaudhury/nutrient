package com.nirmalsprojects.nutrient.test.shoppingcart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.nirmalsprojects.nutrient.dataaccess.shoppingcart.IShoppingCartDataAccess;
import com.nirmalsprojects.nutrient.dataaccess.shoppingcart.ShoppingCartDataAccess;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;
import com.nirmalsprojects.nutrient.module.shoppingcart.ShoppingCartModule;

public class ShoppingCartModuleGivenAddItem {
	
	IShoppingCartModule shoppingCart;
	
	@Before
	public void onStart() {
		IShoppingCartDataAccess dataAccess = new ShoppingCartDataAccess();
		shoppingCart = new ShoppingCartModule(dataAccess);
	}
	
	@Test
	public void ReturnTrueGivenAddItem() {
		shoppingCart.addItem(1, "Apple", 2);
		boolean isItemAdded = shoppingCart.isItemInShoppingCart(1, "Apple");
		assertTrue("Item was not added to the shopping cart", isItemAdded);
	}
	
	@Test
	public void ReturnFalseGivenExistingItem() {
		shoppingCart.addItem(1, "Apple", 2);
		boolean isItemAdded = shoppingCart.addItem(1, "Apple", 2);
		assertFalse("Item was not added to the shopping cart", isItemAdded);
	}
	
	@Test
	public void RemoveItemGivenExistingItem() {
		shoppingCart.addItem(1, "Apple", 2);
		shoppingCart.removeItem(1, "Apple", true);
		boolean isItemInCart = shoppingCart.isItemInShoppingCart(1, "Apple");
		assertFalse("Item was not removed from the cart", isItemInCart);
	}
	
	@Test
	public void RemoveItemGivenUnknwonItem() {
		boolean itemRemoved = shoppingCart.removeItem(1, "Apple", true);
		assertFalse("Non existing item removed from the cart", itemRemoved);
	}

}
