package com.nirmalsprojects.nutrient.dataaccess.types;

import java.util.ArrayList;

/**
 * Class representing a group on ingredients for a recipe.
 */
public class IngredientGroup {
	
	/**
	 * Name of the group
	 */
	public String groupName;
	
	/**
	 * Ingredients for the group
	 */
	public ArrayList<Ingredient> ingredients;
	
	/**
	 * Constructor
	 * 
	 * @param name Group name
	 */
	public IngredientGroup(String name) {
		this.groupName = name;
		ingredients = new ArrayList<Ingredient>();
	}
	
	/**
	 * Adds an ingredient to the group
	 * 
	 * @param ingredient ingredient to add
	 * @return true if the ingredient was added, false otherwise
	 */
	public boolean addIngredient(Ingredient ingredient) {
		return ingredients.add(ingredient);
	}
	
	/**
	 * Gets the name of all the ingredients for the group
	 * @return name of all the ingredients for the group
	 */
	public ArrayList<String> getIngredients() {
		ArrayList<String> ingredientNames = new ArrayList<String>();
		for (Ingredient i : ingredients) {
			ingredientNames.add(i.name);
		}
		return ingredientNames;
	}

}
