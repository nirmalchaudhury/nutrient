package com.nirmalsprojects.nutrient.types;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Representation of an User item
 * 
 * @author Nirmal
 *
 */
public class UserItem {
	
	private static final boolean DEFAULT_IS_REMOVED = false;
	
	public int userId;
	
	public String itemName;
	
	public int quantity;
	
	public DateTime dateAdded;
	
	public boolean isRemoved;

	public UserItem(int userId, String itemName, int quantity, DateTime dateAdded) {
		this.userId = userId;
		this.itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
		this.quantity = quantity;
		this.dateAdded = dateAdded;
		this.isRemoved = DEFAULT_IS_REMOVED;
	}
	
	public UserItem(UserItem item) {
		this.userId = item.userId;
		this.itemName = item.itemName;
		this.quantity = item.quantity;
		this.dateAdded = item.dateAdded;
		this.isRemoved = item.isRemoved;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MMM dd,yyyy HH:mm");
		return "userId:" + userId + " , " 
			 + "itemName:" + itemName + " , " 
			 + "quantity:" + quantity + " , "
			 + "dateAdded:" + dtf.print(dateAdded) + " , "
			 + "isRemoved:" + isRemoved;
	}

}
