package com.nirmalsprojects.nutrient.dataaccess.recipe;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.dataaccess.types.Recipe;

/**
 * Interface for accessing Recipe database
 */
public interface IRecipeDataAccess {
	
	/**
	 * Adds a recipe
	 * 
	 * @param recipe recipe to add
	 * @return true if the recipe was added, false otherwise
	 */
	boolean addRecipe(Recipe recipe);
	
	/**
	 * Returns all the recipes
	 * @return available recipes
	 */
	ArrayList<Recipe> getRecipes();
	
	/**
	 * Gets the recipe from the databse
	 * 
	 * @param recipeName recipe name of interest
	 * @return recipe of interest
	 */
	Recipe getRecipe(String recipeName);
	
	/**
	 * Removes the recipe from the database
	 * 
	 * @param recipeName recipe to remove
	 * @return true if the recipe was removed, false otherwise
	 */
	boolean removeRecipe(String recipeName);
}
