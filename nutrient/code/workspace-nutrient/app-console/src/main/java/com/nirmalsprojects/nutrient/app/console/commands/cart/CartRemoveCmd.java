package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;

/**
 * Sub command to remove items from a shopping cart
 */
public class CartRemoveCmd extends SubCommand {
	
	/**
	 * Command Name
	 */
	private static final String CART_DEL_CMD = "remove";
	
	/**
	 * Command Description
	 */
	private static final String DESCRIPTION = "remove item from the cart";
	
	/**
	 * Command parameters
	 */
	private static final String[] params = new String[]{"userId", "itemName", "isBought"};
	
	/**
	 * Shopping Cart module
	 */
	IShoppingCartModule module;
	
	/**
	 * Constructor
	 * 
	 * @param module Shopping Cart Module
	 */
	public CartRemoveCmd(IShoppingCartModule module) {
		this.module = module;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName() {
		return CART_DEL_CMD;
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
			String itemName = userInput.get(++i);
			String sIsBought = userInput.get(++i);
			boolean isBought = false;
			if (sIsBought.equalsIgnoreCase("true")) {
				isBought = true;
			} else if (sIsBought.equalsIgnoreCase("false")) {
				isBought = false;
			} else {
				return false;
			}
			return module.removeItem(userId, itemName, isBought);
		} catch (Exception e) {
			// parsing error return false;
		}
		return false;
	}

}
