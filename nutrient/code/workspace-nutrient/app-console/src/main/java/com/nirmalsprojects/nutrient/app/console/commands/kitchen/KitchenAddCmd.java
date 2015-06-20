package com.nirmalsprojects.nutrient.app.console.commands.kitchen;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule;

public class KitchenAddCmd extends SubCommand {
	
	private static final String ADD_CMD = "add";
	
	private static final String DESCRIPTION = "add items in the kitchen";
	
	private static final String[] params = new String[]{"userId", "itemName", "quantity"};
	
	IKitchenModule module;
	
	public KitchenAddCmd(IKitchenModule module) {
		this.module = module;
	}

	public String getName() {
		return ADD_CMD;
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
			int quantity = Integer.parseInt(userInput.get(++i));
			return module.addItem(userId, itemName, quantity);
		} catch (Exception e) {
			// parsing error, return false
		}
		return false;
	}
	
}
