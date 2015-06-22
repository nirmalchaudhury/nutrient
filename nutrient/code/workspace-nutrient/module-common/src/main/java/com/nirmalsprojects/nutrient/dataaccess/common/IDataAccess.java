package com.nirmalsprojects.nutrient.dataaccess.common;

/**
 * Interface that allows initializing, connecting and disconnecting
 * to a data store
 * 
 * @author Nirmal
 *
 */
public interface IDataAccess {
	
	/**
	 * Initialize data store
	 */
	void initialize();
	
	/**
	 * Connect to the data store
	 * 
	 * @return true if connection is established, false otherwise
	 */
	boolean connect();
	
	/**
	 * Disconnect from the data store
	 * 
	 * @return true if the connection is disconnected, false otherwise
	 */
	boolean disconnect();
}
