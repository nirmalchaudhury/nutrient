package com.nirmalsprojects.nutrient.module.shoppingcart;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.nirmalsprojects.nutrient.dataaccess.shoppingcart.IShoppingCartDataAccess;
import com.nirmalsprojects.nutrient.module.common.Module;
import com.nirmalsprojects.nutrient.module.common.ModuleType;
import com.nirmalsprojects.nutrient.types.UserItem;

public class ShoppingCartModule extends Module implements IShoppingCartModule {
	
	/**
	 * Shopping cart module type
	 */
	private final static ModuleType MODULE_TYPE = ModuleType.SHOPPING_CART;
	
	/**
	 * Listeners of shopping cart events
	 */
	private ArrayList<IShoppingCartListener> listeners;
	
	/**
	 * Shopping cart item data store
	 */
	private IShoppingCartDataAccess shoppingCart;

	/**
	 * Constructor
	 * 
	 * @param shoppingCart Shopping cart data store
	 */
	public ShoppingCartModule(IShoppingCartDataAccess shoppingCart) {
		this.shoppingCart = shoppingCart;
		listeners = new ArrayList<IShoppingCartListener>();
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.module.common.IModule#getModuleType()
	 */
	public ModuleType getModuleType() {
		return MODULE_TYPE;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule#addListener(com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartListener)
	 */
	public void addListener(IShoppingCartListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule#getItems(int)
	 */
	public ArrayList<UserItem> getItems(int userId) {
		boolean getRemovedItems = false;
		DateTime currentTime = new DateTime();
		return shoppingCart.getItems(userId, getRemovedItems, currentTime);
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule#isItemInShoppingCart(int, java.lang.String)
	 */
	public boolean isItemInShoppingCart(int userId, String itemName) {
		boolean getRemovedItems = false;
		DateTime currentTime = new DateTime();
		ArrayList<UserItem> items = shoppingCart.getItems(userId, getRemovedItems, currentTime);
		return items.size() != 0;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule#addItem(int, java.lang.String, int)
	 */
	public boolean addItem(int userId, String itemName, int quantity) {
		return addItem(userId, itemName, quantity, new DateTime());
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule#addItem(int, java.lang.String, int, org.joda.time.DateTime)
	 */
	public boolean addItem(int userId, String itemName, int quantity, DateTime date) {
		if (isItemInShoppingCart(userId, itemName)) {
			shoppingCart.updateIsRemoved(userId, itemName, true);
		}
		UserItem item = new UserItem(userId, itemName, quantity, date);
		if (shoppingCart.addItem(item)) {
			notifyListenersOnNewItem(item);
			return true;
		} 
		return false;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule#removeItem(int, java.lang.String, boolean)
	 */
	public boolean removeItem(int userId, String itemName, boolean isBought) {
		boolean isItemRemoved = false;
		if (isItemInShoppingCart(userId, itemName)) {
			DateTime currentTime = new DateTime();
			ArrayList<UserItem> item = shoppingCart.getItems(userId, itemName, false, currentTime);
			isItemRemoved = isBought ? shoppingCart.updateIsRemoved(userId, itemName, true) : shoppingCart.removeItem(userId, itemName);
			if (isBought && isItemRemoved) {
				notifyListenersOnBoughtItem(item.get(0));
			}
		}
		return isItemRemoved;
	}
	
	/**
	 * Notifies listeners of a new item in the shopping cart
	 * 
	 * @param item item added to shopping cart
	 */
	private void notifyListenersOnNewItem(UserItem item) {
		for (IShoppingCartListener listener : listeners) {
			listener.onNewShoppingCartItem(item);
		}
	}
	
	/**
	 * Notifies listeners of a bought item
	 * 
	 * @param item bought item
	 */
	private void notifyListenersOnBoughtItem(UserItem item) {
		for (IShoppingCartListener listener : listeners) {
			listener.onBoughtShoppingCartItem(item);
		}
	}

}
