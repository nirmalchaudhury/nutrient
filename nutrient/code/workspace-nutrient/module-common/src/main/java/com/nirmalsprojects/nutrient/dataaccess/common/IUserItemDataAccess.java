package com.nirmalsprojects.nutrient.dataaccess.common;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.nirmalsprojects.nutrient.types.UserItem;

/**
 * Interface that allows getting and modifying of user item database
 * 
 * @author Nirmal
 *
 */
public interface IUserItemDataAccess extends IDataAccess {
	
	/**
	 * Gets a list of items that are associated with a specific user id and
	 * added before a specific date
	 * 
	 * @param userId user id
	 * @param dateTime item added before this date
	 * @return list of items
	 */
	ArrayList<UserItem> getItems(int userId, String itemName, DateTime dateTime);
	
	/**
	 * Gets a list of items that are associated with a specific user id, whether
	 * or not the item is removed and added before a specific date
	 * 
	 * @param userId user id
	 * @param isRemoved whether or not the item is removed
	 * @param dateTime item added before this date
	 * @return list of items
	 */
	ArrayList<UserItem> getItems(int userId, boolean isRemoved, DateTime dateTime);
	
	/**
	 * Gets a list of items that are associated with a specific user id, item name, whether
	 * or not the item is removed and added before a specific date
	 * 
	 * @param userId user id
	 * @param itemName item name
	 * @param isRemoved whether or not the item is removed
	 * @param dateTime item added before this date
	 * @return list of items
	 */
	ArrayList<UserItem> getItems(int userId, String itemName, boolean isRemoved, DateTime dateTime);
	
	/**
	 * Adds the item to the internal store
	 * 
	 * @param item item to add
	 * @return true if it was successfully added, false otherwise
	 */
	boolean addItem(UserItem item);
	
	/**
	 * Deletes the entry with the specified userId and itemName if it is available and marked has not-removed.
	 * 
	 * @param userId user id of the entry to remove
	 * @param itemName item name of the entry to remove
	 * @return true if the entry is deleted
	 */
	boolean removeItem(int userId, String itemName);
	
	/**
	 * Updates the isRemoved flag of the user item
	 * 
	 * @param userId user id of the entry to modify isRemoved flag
	 * @param itemName itemName of entry to modify the isREmoved flag
	 * @param isRemoved flag to indicate if the entry should be marked removed
	 * @return true on success, false otherwise
	 */
	public boolean updateIsRemoved(int userId, String itemName,
			boolean isRemoved);

}
