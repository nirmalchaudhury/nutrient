package com.nirmalsprojects.nutrient.app.console.commands.kitchen;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule;

public class KitchenRemoveCmd extends SubCommand {
	
	private static final String DEL_CMD = "remove";
	
	private static final String DESCRIPTION = "remove item from the kitchen";
	
	private static final String[] params = new String[]{"userId", "itemName"};
	
	IKitchenModule module;
	
	public KitchenRemoveCmd(IKitchenModule module) {
		this.module = module;
	}

	public String getName() {
		return DEL_CMD;
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
			return module.removeItem(userId, itemName);
		} catch (Exception e) {
			// parsing error return false;
		}
		return false;
	}

}
