package com.nirmalsprojects.nutrient.module.recipe;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.dataaccess.types.Recipe;

public interface IRecipeModule {
	
	/**
	 * Adds a recipe
	 * 
	 * @param recipe recipe to add
	 * @return true if the recipe was added, false otherwise
	 */
	boolean addRecipe(Recipe recipe);
	
	/**
	 * Gets the recipe from the databse
	 * 
	 * @param recipeName recipe name of interest
	 * @return recipe of interest
	 */
	Recipe getRecipe(String recipeName);
	
	/**
	 * List of recipes that contain the desired ingredients
	 * 
	 * @param ingridients ingredients that needs to be included in the recipe
	 * @return recipes with the desired ingredients
	 */
	ArrayList<RecipeResponse> getRecipes(ArrayList<String> ingridients);
	
	/**
	 * Removes the recipe from the database
	 * 
	 * @param recipeName recipe to remove
	 * @return true if the recipe was removed, false otherwise
	 */
	boolean removeRecipe(String recipeName);

}
