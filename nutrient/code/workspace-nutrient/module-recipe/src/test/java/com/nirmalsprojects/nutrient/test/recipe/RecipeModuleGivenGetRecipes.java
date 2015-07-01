package com.nirmalsprojects.nutrient.test.recipe;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.nirmalsprojects.nutrient.dataaccess.recipe.IRecipeDataAccess;
import com.nirmalsprojects.nutrient.dataaccess.recipe.RecipeDataAccess;
import com.nirmalsprojects.nutrient.dataaccess.types.Ingredient;
import com.nirmalsprojects.nutrient.dataaccess.types.IngredientGroup;
import com.nirmalsprojects.nutrient.dataaccess.types.Recipe;
import com.nirmalsprojects.nutrient.module.recipe.IRecipeModule;
import com.nirmalsprojects.nutrient.module.recipe.RecipeModule;
import com.nirmalsprojects.nutrient.module.recipe.RecipeResponse;

/**
 * Unit test for getting recipes that include desired ingredients
 */
public class RecipeModuleGivenGetRecipes {
	
	/**
	 * Recipe module under test
	 */
	IRecipeModule module;
	
	@Before
	public void intialize() {
		IRecipeDataAccess recipeDataAccess = new RecipeDataAccess();
		module = new RecipeModule(recipeDataAccess);
		module.addRecipe(createPieRecipe());
	}
	
	/**
	 * Verifies the recipe module returns the pie recipe given all pie ingredients
	 */
	@Test
	public void ReturnPieRecipeGivenPieIngredients() {
		ArrayList<String> ingredients = new ArrayList<String>();
		ingredients.add("Eggs");
		ingredients.add("Vanilla");
		ingredients.add("Honey");
		ingredients.add("Butter");
		ingredients.add("Pecan");
		ingredients.add("Water");
		ingredients.add("Almond Flour");
		ingredients.add("Coconut Flour");
		ingredients.add("Butter");
		ingredients.add("Salt");
		ArrayList<RecipeResponse> recipes  = module.getRecipes(ingredients);
		if (recipes.size() == 1) {
			assertTrue("Did not return pie recipe, given its ingredeints", recipes.get(0).recipe.name.equalsIgnoreCase("pie"));
		} else {
			fail("Didnt not return pie recipe, given its ingredeints");
		}
	}
	
	/**
	 * Verifies the recipe module returns the pie recipe given some pie ingredients
	 */
	@Test
	public void ReturnPieRecipeGivenPartialPieIngredients() {
		ArrayList<String> ingredients = new ArrayList<String>();
		ingredients.add("Eggs");
		ingredients.add("Vanilla");
		ingredients.add("Honey");
		ingredients.add("Butter");
		ingredients.add("Pecan");
		ingredients.add("Water");
		ingredients.add("Almond Flour");
		ingredients.add("Coconut Flour");
		ArrayList<RecipeResponse> recipes  = module.getRecipes(ingredients);
		if (recipes.size() == 1) {
			assertTrue("Did not return pie recipe, given most of its ingredeints", recipes.get(0).recipe.name.equalsIgnoreCase("pie"));
		} else {
			fail("Didnt not return pie recipe, given most of its ingredeints");
		}
	}
	
	/**
	 * Verifies no recipes are returned when given random ingredients
	 */
	@Test
	public void ReturnNoRecipesGivenDifferntIngredients() {
		ArrayList<String> ingredients = new ArrayList<String>();
		ingredients.add("Avacado");
		ingredients.add("Banada");
		ingredients.add("Chilli");
		ArrayList<RecipeResponse> recipes  = module.getRecipes(ingredients);
		assertTrue("Returned recipes when given unrelated ingredeints", recipes.size() == 0);
	}
	
	/**
	 * Creates a pie recipe
	 */
	private Recipe createPieRecipe() {
		IngredientGroup crustIngredients = new IngredientGroup("Crust");
		crustIngredients.addIngredient(new Ingredient("Water",100,"ml"));
		crustIngredients.addIngredient(new Ingredient("Almond Flour",2,"cups"));
		crustIngredients.addIngredient(new Ingredient("Coconut Flour",0.5,"cups"));
		crustIngredients.addIngredient(new Ingredient("Butter",2,"tbs"));
		crustIngredients.addIngredient(new Ingredient("Salt",0.25,"tbls"));
		
		IngredientGroup fillingIngredients = new IngredientGroup("Filling");
		fillingIngredients.addIngredient(new Ingredient("Eggs",3,"large"));
		fillingIngredients.addIngredient(new Ingredient("Honey",0.5,"cup"));
		fillingIngredients.addIngredient(new Ingredient("Vanilla",2,"tbls"));
		fillingIngredients.addIngredient(new Ingredient("Pecan",1,"cup"));
		fillingIngredients.addIngredient(new Ingredient("Butter",1,"tbls"));
		
		Recipe pie = new Recipe("pie");
		pie.name = "pie";
		pie.time = 2;
		pie.picUrl = "home";
		pie.addIngredientGroups(crustIngredients);
		pie.addIngredientGroups(fillingIngredients);
		return pie;
	}

}
