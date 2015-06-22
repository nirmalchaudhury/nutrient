package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;

/**
 * Command to add items to a a shopping cart
 * 
 * @author Nirmal
 *
 */
public class CartAddCmd extends SubCommand {
	
	private static final String CART_ADD_CMD = "add";
	
	private static final String DESCRIPTION = "Add item to the cart";
	
	IShoppingCartModule module;
	
	private static final String[] params = new String[]{"userId", "itemName", "quantity"};
	
	public CartAddCmd(IShoppingCartModule module) {
		this.module = module;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName() {
		return CART_ADD_CMD;
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
			int quantity = Integer.parseInt(userInput.get(++i));
			return module.addItem(userId, itemName, quantity);
		} catch (Exception e) {
			// parsing error, return false
		}
		return false;
	}

}
