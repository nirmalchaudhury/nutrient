package com.nirmalsprojects.nutrient.module.kitchen.types;

import org.joda.time.DateTime;

public class KitchenItem {
	
	private static final boolean DEFAULT_IS_REMOVED = false;
	
	public int userId;
	
	public String itemName;
	
	public int quantity;
	
	public DateTime dateAdded;
	
	public boolean isRemoved;

	public KitchenItem(int userId, String itemName, int quantity, DateTime dateAdded) {
		this.userId = userId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.dateAdded = dateAdded;
		this.isRemoved = DEFAULT_IS_REMOVED;
	}
	
	public KitchenItem(KitchenItem item) {
		this.userId = item.userId;
		this.itemName = item.itemName;
		this.quantity = item.quantity;
		this.dateAdded = item.dateAdded;
		this.isRemoved = item.isRemoved;
	}
	
	@Override
	public String toString() {
		return "userId:" + userId + "," 
			 + "itemName:" + itemName + "," 
			 + "quantity:" + quantity + ","
			 + "dateAdded:" + dateAdded + ","
			 + "isRemoved:" + isRemoved;
	}

}
