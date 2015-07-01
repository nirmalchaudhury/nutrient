package com.nirmalsprojects.nutrient.app.console.commands.recipe;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.dataaccess.types.Ingredient;
import com.nirmalsprojects.nutrient.dataaccess.types.IngredientGroup;
import com.nirmalsprojects.nutrient.dataaccess.types.Recipe;
import com.nirmalsprojects.nutrient.module.recipe.IRecipeModule;

public class RecipeAddCmd extends SubCommand {
	
	/**
	 * Add command
	 */
	private static final String ADD_CMD = "add";
	
	/**
	 * Description
	 */
	private static final String DESCRIPTION = "add items in the kitchen";
	
	/**
	 * Parameters
	 */
	private static final String[] params = new String[]{"recipeName"};
	
	/**
	 * Recipe module
	 */
	IRecipeModule module;
	
	/**
	 * Constructor
	 * 
	 * @param Recipe module
	 */
	public RecipeAddCmd(IRecipeModule module) {
		this.module = module;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ISubCommand#getParameters()
	 */
	public List<String> getParameters() {
		return Arrays.asList(params);
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName() {
		return ADD_CMD;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getDescription()
	 */
	public String getDescription() {
		return DESCRIPTION;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#executeCommand(java.util.List)
	 */
	public boolean executeCommand(List<String> userInput) {
		if (!isCommandParsable(userInput)) {
			return false;
		}
		try {
			int i = SUBCOMMAND_INDEX;
			String recipeName = userInput.get(++i);
			return module.addRecipe(createPieRecipe());
		} catch (Exception e) {
			// parsing error, return false
		}
		return false;
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
