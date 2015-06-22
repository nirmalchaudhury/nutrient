package com.nirmalsprojects.nutrient.dataaccess.kitchen;

import com.nirmalsprojects.nutrient.dataaccess.common.UserItemDataAccess;

public class KitchenDataAccess extends UserItemDataAccess implements IKitchenDataAccess {

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IDataAccess#initialize()
	 */
	public void initialize() {
		// Do Nothing
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IDataAccess#connect()
	 */
	public boolean connect() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.nirmalsprojects.nutrient.dataaccess.common.IDataAccess#disconnect()
	 */
	public boolean disconnect() {
		return true;
	}
	
}
