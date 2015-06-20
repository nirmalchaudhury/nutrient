package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;

public class CartRemoveCmd extends SubCommand {
	
	private static final String CART_DEL_CMD = "remove";
	
	private static final String DESCRIPTION = "remove item from the cart";
	
	private static final String[] params = new String[]{"userId", "itemName", "isBought"};
	
	IShoppingCartModule module;
	
	public CartRemoveCmd(IShoppingCartModule module) {
		this.module = module;
	}
	
	public String getName() {
		return CART_DEL_CMD;
	}
	
	public String getDescription() {
		return DESCRIPTION;
	}
	
	public List<String> getParameters() {
		return Arrays.asList(params);
	}

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
