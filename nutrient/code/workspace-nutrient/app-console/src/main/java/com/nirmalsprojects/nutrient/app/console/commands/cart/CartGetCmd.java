package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;
import com.nirmalsprojects.nutrient.types.UserItem;

/**
 * Sub command to get items from a shopping cart
 */
public class CartGetCmd extends SubCommand {

	/**
	 * Command Name
	 */
	private static final String CART_GET_CMD = "get";
	
	/**
	 * Command Description
	 */
	private static final String DESCRIPTION = "get items from the shopping cart";
	
	/**
	 * Command parameters
	 */
	private static final String[] params = new String[]{"userId"};
	
	/**
	 * Shopping Cart module
	 */
	private IShoppingCartModule module;
	
	/**
	 * Constructor
	 * 
	 * @param module Shopping cart module
	 */
	public CartGetCmd(IShoppingCartModule module) {
		this.module = module;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName() {
		return CART_GET_CMD;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getDescription()
	 */
	public String getDescription() {
		return DESCRIPTION;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ISubCommand#getParameters()
	 */
	public List<String> getParameters() {
		return Arrays.asList(params);
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
			int userId = Integer.parseInt(userInput.get(++i));
			printItems(userId);
			return true;
		} catch (Exception e) {
			// parsing error, return false
		}
		return false;
	}
	
	/**
	 * Prints item from the shopping cart
	 * 
	 * @param userId user id of the shopping cart
	 */
	private void printItems(int userId) {
		System.out.println("Shopping Cart Items:");
		ArrayList<UserItem> items = module.getItems(userId);
		for (int i=0; i<items.size(); i++) {
			System.out.println(items.get(i));
		}
	}

}
