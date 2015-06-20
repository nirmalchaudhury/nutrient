package com.nirmalsprojects.nutrient.dataaccess.common;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.nirmalsprojects.nutrient.types.UserItem;

public abstract class UserItemDataAccess implements IUserItemDataAccess {
    
    /**
     * User item entries
     */
    private ArrayList<UserItem> entries;
	
    /**
     * Constructor
     */
	public UserItemDataAccess() {
		entries = new ArrayList<UserItem>();
	}
	
	public ArrayList<UserItem> getItems(int userId, String itemName, DateTime dateTime) {
		ArrayList<UserItem> item = new ArrayList<UserItem>();
		for (UserItem entry : entries) {
			if ((entry.userId == userId) && (entry.itemName.equalsIgnoreCase(itemName))
					&& (entry.dateAdded.isBefore(dateTime.getMillis()))) {
				item.add(entry);
			}
		}
		return item;
	}
	
	public ArrayList<UserItem> getItems(int userId, boolean isRemoved, DateTime dateTime) {
		ArrayList<UserItem> item = new ArrayList<UserItem>();
		for (UserItem entry : entries) {
			if ((entry.userId == userId) && (entry.isRemoved == isRemoved) 
					&& (entry.dateAdded.isBefore(dateTime.getMillis()))) {
				item.add(entry);
			}
		}
		return item;
	}
	
	public ArrayList<UserItem> getItems(int userId, String itemName, boolean isRemoved, DateTime dateTime) {
		ArrayList<UserItem> item = new ArrayList<UserItem>();
		for (UserItem entry : entries) {
			if ((entry.userId == userId) && (entry.itemName.equalsIgnoreCase(itemName)) 
					&& (entry.isRemoved == isRemoved) && (entry.dateAdded.isBefore(dateTime.getMillis()))) {
				item.add(entry);
			}
		}
		return item;
	}
	
	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IUserItemDataAccess#addItem(com.nirmalsprojects.nutrient.types.UserItem)
	 */
	public boolean addItem(UserItem item) {
		return entries.add(new UserItem(item));
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IUserItemDataAccess#removeItem(int, java.lang.String)
	 */
	public boolean removeItem(int userId, String itemName) {
		boolean itemFound = false;
		int itemIdIndex = 0;
		for (int i=0; i<entries.size(); i++) {
			itemIdIndex = i;
			if ((entries.get(i).userId == userId) && (entries.get(i).itemName.equalsIgnoreCase(itemName)
					&& !(entries.get(i).isRemoved))) {
				itemFound = true;
				break;
			}
		}
		if (itemFound) {
			entries.remove(itemIdIndex);
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IUserItemDataAccess#updateIsRemoved(int, java.lang.String, boolean)
	 */
	public boolean updateIsRemoved(int userId, String itemName,
			boolean isRemoved) {
		for (UserItem item : entries) {
			if ((item.userId == userId)
					&& (item.itemName.equalsIgnoreCase(itemName) && !item.isRemoved)) {
				item.isRemoved = true;
				return true;
			}
		}
		return false;
	}

}
