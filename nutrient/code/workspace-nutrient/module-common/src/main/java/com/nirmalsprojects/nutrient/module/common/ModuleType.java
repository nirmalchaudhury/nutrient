package com.nirmalsprojects.nutrient.module.common;

/**
 * Available Module Types
 * 
 * @author Nirmal
 *
 */
public enum ModuleType {	
	ITEM,
	KITCHEN,
	SHOPPING_CART;
	
	/**
	 * Gets the module type based on a specified string representation
	 * 
	 * @param value string representation of the desired module type
	 * @return module type
	 */
	public ModuleType getValue(String value) {
		for (ModuleType v : values()) {
			if (v.name().equalsIgnoreCase(value)) {
				return v;
			}
		}
		return null;
	}
}
