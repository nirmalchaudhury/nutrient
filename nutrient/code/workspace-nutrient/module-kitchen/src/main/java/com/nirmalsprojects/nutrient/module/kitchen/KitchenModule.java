package com.nirmalsprojects.nutrient.module.kitchen;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.nirmalsprojects.nutrient.dataaccess.kitchen.IKitchenDataAccess;
import com.nirmalsprojects.nutrient.module.common.Module;
import com.nirmalsprojects.nutrient.module.common.ModuleType;
import com.nirmalsprojects.nutrient.types.UserItem;

/**
 * Kitchen Module
 * 
 * @author Nirmal
 *
 */
public class KitchenModule extends Module implements IKitchenModule {

	/**
	 * Module type
	 */
	private final static ModuleType MODULE_TYPE = ModuleType.KITCHEN;
	
	/**
	 * list of listeners to alert
	 */
	private ArrayList<IKitchenListener> listeners;
	
	/**
	 * Kitchen entries
	 */
	IKitchenDataAccess kitchen;
	
	/**
	 * Constructor
	 * @param kitchen
	 */
	public KitchenModule(IKitchenDataAccess kitchen) {
		this.kitchen = kitchen;
		listeners = new ArrayList<IKitchenListener>();
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.common.IModule#getModuleType()
	 */
	public ModuleType getModuleType() {
		return MODULE_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule#addListener(com.nirmalsprojects.nutrient.module.kitchen.IKitchenListener)
	 */
	public void addListener(IKitchenListener listener) {
		listeners.add(listener);
	}
	
	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule#getItems(int)
	 */
	public ArrayList<UserItem> getItems(int userId) {
		boolean getRemovedItems = false;
		DateTime currentTime = new DateTime();
		return kitchen.getItems(userId, getRemovedItems, currentTime);
	}
	
	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule#getItems(int, java.lang.String)
	 */
	public ArrayList<UserItem> getItems(int userId, String itemName) {
		DateTime currentTime = new DateTime();
		return kitchen.getItems(userId, itemName, currentTime);
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule#isItemInKitchen(int, java.lang.String)
	 */
	public boolean isItemInKitchen(int userId, String itemName) {
		boolean getRemovedItems = false;
		DateTime currentTime = new DateTime();
		ArrayList<UserItem> items = kitchen.getItems(userId, itemName, getRemovedItems, currentTime);
		return items.size() != 0;
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule#addItem(int, java.lang.String, int)
	 */
	public boolean addItem(int userId, String itemName, int quantity) {
		if (isItemInKitchen(userId, itemName)) {
			kitchen.updateIsRemoved(userId, itemName, true);
		}
		UserItem item = new UserItem(userId, itemName, quantity, new DateTime());
		if (kitchen.addItem(item)) {
			notifyListenersOnNewItem(item);
			return true;
		} 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule#removeItem(int, java.lang.String)
	 */
	public boolean removeItem(int userId, String itemName) {
		if (isItemInKitchen(userId, itemName)) {
			UserItem itemToRemove = getItem(userId, itemName);
			boolean isRemoved = kitchen.updateIsRemoved(userId, itemName, true);
			if (isRemoved) {
				notifyListenersOnRemovedItem(itemToRemove);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets items from the shopping cart that are not removed and were added before the current time
	 * 
	 * @param userId user id
	 * @param itemName item name
	 * @return items that are not removed and were added before the current time
	 */
	private UserItem getItem(int userId, String itemName) {
		boolean getRemovedItems = false;
		DateTime currentTime = new DateTime();
		ArrayList<UserItem> items = kitchen.getItems(userId, itemName, getRemovedItems, currentTime);
		return items.get(0);
	}
	
	/**
	 * Notify listeners of the added item
	 * 
	 * @param item added item
	 */
	private void notifyListenersOnNewItem(UserItem item) {
		for (IKitchenListener listener : listeners) {
			listener.onNewKitchenItem(item);
		}
	}
	
	/**
	 * Notify listeners of the removed item
	 * 
	 * @param item removed item
	 */
	private void notifyListenersOnRemovedItem(UserItem item) {
		for (IKitchenListener listener : listeners) {
			listener.onRemovedKitchenItem(item);
		}
	}

}
