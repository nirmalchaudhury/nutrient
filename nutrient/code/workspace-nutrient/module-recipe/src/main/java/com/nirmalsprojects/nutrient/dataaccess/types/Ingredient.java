package com.nirmalsprojects.nutrient.dataaccess.types;

import java.util.ArrayList;

/**
 * Class representing an ingredient
 */
public class Ingredient {
	
	/**
	 * Name of the ingredient
	 */
	public String name;
	
	/**
	 * Quantity
	 */
	public double quanity;
	
	/**
	 * Units of the quantity
	 */
	public String unit;

	/**
	 * Constructor
	 * 
	 * @param name ingredient name
	 * @param quanity ingredient quantity
	 * @param unit ingredient quantity unit
	 */
	public Ingredient(String name, double quanity, String unit) {
		this.name = name;
		this.quanity = quanity;
		this.unit = unit;
	}
	
	/**
	 * Checks if the ingredient is in the list of provided ingredients
	 * 
	 * @param ingredients ingredients to search in
	 * @return true if this ingredient is in the list, false otherwise
	 */
	public boolean isInList(ArrayList<String> ingredients) {
		for (String i : ingredients) {
			if (name.equalsIgnoreCase(i)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", quanity=" + quanity + ", unit="
				+ unit + "]";
	}

}
