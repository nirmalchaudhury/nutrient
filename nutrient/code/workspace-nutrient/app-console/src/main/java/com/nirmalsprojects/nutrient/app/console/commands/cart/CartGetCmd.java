package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.shoppingcart.IShoppingCartModule;
import com.nirmalsprojects.nutrient.types.UserItem;

public class CartGetCmd extends SubCommand {

	private static final String CART_GET_CMD = "get";
	
	private static final String DESCRIPTION = "get items from the shopping cart";
	
	private static final String[] params = new String[]{"userId"};
	
	private IShoppingCartModule module;
	
	public CartGetCmd(IShoppingCartModule module) {
		this.module = module;
	}
	
	public String getName() {
		return CART_GET_CMD;
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
			printItems(userId);
			return true;
		} catch (Exception e) {
			// parsing error, return false
		}
		return false;
	}
	
	private void printItems(int userId) {
		System.out.println("Shopping Cart Items:");
		ArrayList<UserItem> items = module.getItems(userId);
		for (int i=0; i<items.size(); i++) {
			System.out.println(items.get(i));
		}
	}

}
