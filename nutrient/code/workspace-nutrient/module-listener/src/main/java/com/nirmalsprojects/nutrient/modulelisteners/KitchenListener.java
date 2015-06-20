package com.nirmalsprojects.nutrient.modulelisteners;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTime;

import com.nirmalsprojects.nutrient.module.common.ModuleType;
import com.nirmalsprojects.nutrient.module.common.Modules;
import com.nirmalsprojects.nutrient.module.kitchen.IKitchenListener;
import com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;
import com.nirmalsprojects.nutrient.types.UserItem;

public class KitchenListener implements IKitchenListener {
	
	/**
	 * Shopping cart item module
	 */
	private IShoppingCartModule shoppingCart;
	
	/**
	 * Kitchen items module
	 */
	private IKitchenModule kitchen;
	
	/**
	 * Constructor
	 * 
	 * @param modules handle to all the registered modules
	 */
	public KitchenListener(Modules modules) {
		shoppingCart = (IShoppingCartModule) modules.getModule(ModuleType.SHOPPING_CART);
		kitchen = (IKitchenModule) modules.getModule(ModuleType.KITCHEN);
	}
	
	/**
	 * Registers itself with the Kitchen module so that it can be notify of any kitchen module
	 * events
	 */
	public void register() {
		if (kitchen != null) {
			kitchen.addListener(this);
		}
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenListener#onNewKitchenItem(com.nirmalsprojects.nutrient.types.UserItem)
	 */
	public void onNewKitchenItem(UserItem item) {
		scheduleItemToCartTask(item);
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.module.kitchen.IKitchenListener#onRemovedKitchenItem(com.nirmalsprojects.nutrient.types.UserItem)
	 */
	public void onRemovedKitchenItem(UserItem item) {
		// Do nothing
	}
	
	/**
	 * Schedules a task to enter the item in the shopping cart based on user's purchase history
	 * of the item.
	 * 
	 * @param item item added to the kitchen
	 */
	private void scheduleItemToCartTask(UserItem item) {
		ArrayList<UserItem> itemHistory = kitchen.getItems(item.userId, item.itemName);
		if (itemHistory.size() > 1) {
			DateTime nextPurchaseDate = calculateNextPurchaseDate(itemHistory);
			shoppingCart.addItem(item.userId, item.itemName, item.quantity, nextPurchaseDate);
			System.out.println(item.itemName + " next purchase date: " + nextPurchaseDate);
		}
	}
	
	/**
	 * Calculates time remaining for next purchase based on the item's purchase history
	 * 
	 * @param itemHistory history of item added to the kitchen
	 * @return time remaining for next purchases
	 */
	public static long calculatePurchaseTimeRemaining(ArrayList<UserItem> itemHistory) {
		if (itemHistory.size() < 2) {
			// item history should at least have two entries
			return 0;
		}
		long itemAddedTimeDiffsTotal = 0;
		int numItemAddedTimeDiffs = 0;
		for (int i = 1; i < itemHistory.size(); i++) {
			long previousItemAddedTime = itemHistory.get(i - 1).dateAdded.getMillis();
			long currentItemAddedTime = itemHistory.get(i).dateAdded.getMillis();
			long itemAddedTimeDiff = currentItemAddedTime - previousItemAddedTime;
			itemAddedTimeDiffsTotal += itemAddedTimeDiff;
			numItemAddedTimeDiffs++;
		}
		long averageItemAddedTimeDiffs = itemAddedTimeDiffsTotal/numItemAddedTimeDiffs;
		return averageItemAddedTimeDiffs;
	}
	
	/**
	 * Calculates time remaining for next purchase based on the item's purchase history
	 * 
	 * @param itemHistory history of item added to the kitchen
	 * @return time remaining for next purchases
	 */
	public static DateTime calculateNextPurchaseDate(ArrayList<UserItem> itemHistory) {
		if (itemHistory.size() < 2) {
			// item history should at least have two entries
			return null;
		}
		long itemAddedTimeDiffsTotal = 0;
		int numItemAddedTimeDiffs = 0;
		for (int i = 1; i < itemHistory.size(); i++) {
			long previousItemAddedTime = itemHistory.get(i - 1).dateAdded.getMillis();
			long currentItemAddedTime = itemHistory.get(i).dateAdded.getMillis();
			long itemAddedTimeDiff = currentItemAddedTime - previousItemAddedTime;
			itemAddedTimeDiffsTotal += itemAddedTimeDiff;
			numItemAddedTimeDiffs++;
		}
		long averageItemAddedTimeDiffs = itemAddedTimeDiffsTotal/numItemAddedTimeDiffs;
		DateTime nextPurchaseDate = new DateTime().plus(averageItemAddedTimeDiffs);
		return nextPurchaseDate;
	}
	
}
