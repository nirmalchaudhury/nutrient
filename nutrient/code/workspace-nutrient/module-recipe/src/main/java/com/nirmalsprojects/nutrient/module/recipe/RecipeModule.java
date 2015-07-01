package com.nirmalsprojects.nutrient.module.recipe;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.dataaccess.recipe.IRecipeDataAccess;
import com.nirmalsprojects.nutrient.dataaccess.types.Ingredient;
import com.nirmalsprojects.nutrient.dataaccess.types.Recipe;

/**
 * Class containing business logic of the recipe module
 */
public class RecipeModule implements IRecipeModule {
	
	/**
	 * Data store that contains the recipes
	 */
	IRecipeDataAccess recipeDataAccess;
	
	/**
	 * Constructor
	 * 
	 * @param recipeDataAccess Recipe data store
	 */
	public RecipeModule(IRecipeDataAccess recipeDataAccess) {
		this.recipeDataAccess = recipeDataAccess;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.module.recipe.IRecipeModule#addRecipe(com.nirmalsprojects.nutrient.dataaccess.types.Recipe)
	 */
	public boolean addRecipe(Recipe recipe) {
		boolean itemAdded = false;
		if (recipeDataAccess.getRecipe(recipe.name) == null) {
			itemAdded = recipeDataAccess.addRecipe(recipe);
		}
		return itemAdded;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.module.recipe.IRecipeModule#getRecipe(java.lang.String)
	 */
	public Recipe getRecipe(String recipeName) {
		return recipeDataAccess.getRecipe(recipeName);
	}

	/**
	 * @see com.nirmalsprojects.nutrient.module.recipe.IRecipeModule#getRecipes(java.util.ArrayList)
	 */
	public ArrayList<RecipeResponse> getRecipes(ArrayList<String> availableIngredients) {
		ArrayList<RecipeResponse> filteredRecipes = new ArrayList<RecipeResponse>();
		for (Recipe r : recipeDataAccess.getRecipes()) {
			ArrayList<Ingredient> missingIngredients = r.getMissingIngredients(availableIngredients);
			if ((missingIngredients.size()/r.getIngredients().size()) < 0.5) {
				filteredRecipes.add(new RecipeResponse(r,missingIngredients));
			}
		}
		return filteredRecipes;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.module.recipe.IRecipeModule#removeRecipe(java.lang.String)
	 */
	public boolean removeRecipe(String recipeName) {
		return recipeDataAccess.removeRecipe(recipeName);
	}
	
}
