package com.nirmalsprojects.nutrient.dataaccess.types;

/**
 * Class representing an ingredient
 *
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

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", quanity=" + quanity + ", unit="
				+ unit + "]";
	}

}
