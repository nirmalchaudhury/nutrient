package com.nirmalsprojects.nutrient.dataaccess.types;

import java.util.ArrayList;

/**
 * Class representing a recipe
 */
public class Recipe {
	
	/**
	 * Name of the recipe
	 */
	public String name;
	
	/**
	 * Time takes to make the recipe in hrs
	 */
	public int time;
	
	/**
	 * URL of the picture
	 */
	public String picUrl;
	
	/**
	 * List of ingredient groups
	 */
	public ArrayList<IngredientGroup> ingredientGroups;
	
	/**
	 * step by step instructions on how to make the recipe
	 */
	public ArrayList<String> steps;
	
	/**
	 * Constructor
	 * 
	 * @param name Recipe name
	 */
	public Recipe(String name) {
		this.name = name;
		ingredientGroups = new ArrayList<IngredientGroup>();
		steps = new ArrayList<String>();
	}
	
	/**
	 * Adds an ingredient group
	 * 
	 * @param group group to add
	 * @return true if the group was added, false otherwise
	 */
	public boolean addIngredientGroups(IngredientGroup group) {
		return ingredientGroups.add(group);
	}
	
	/**
	 * Gets the ingredients that are missing from the ingredient names passed in
	 * 
	 * @param ingredients ingredients to compare against
	 * @return list of missing ingredients
	 */
	public ArrayList<Ingredient> getMissingIngredients(ArrayList<String> ingredients){	
		ArrayList<Ingredient> missingIngredients = new ArrayList<Ingredient>();
		for (Ingredient i : getIngredients()) {
			if (!i.isInList(ingredients)) {
				missingIngredients.add(i);
			}
		}
		return missingIngredients;
	}
	
	/**
	 * Gets the list of all the ingredients for the recipe
	 * 
	 * @return ingredients for the recipe
	 */
	public ArrayList<Ingredient> getIngredients() {
		ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>();
		for (IngredientGroup i : ingredientGroups) {
			allIngredients.addAll(i.ingredients);
		}
		return allIngredients;
	}
	
	@Override
	public String toString() {
		return "Recipe [name=" + name + ", time=" + time + ", picUrl=" + picUrl
				+ ", ingredientGroups=" + ingredientGroups + ", steps=" + steps
				+ "]";
	}
}
