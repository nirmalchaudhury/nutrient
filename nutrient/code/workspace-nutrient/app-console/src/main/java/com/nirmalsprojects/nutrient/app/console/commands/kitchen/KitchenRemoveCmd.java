package com.nirmalsprojects.nutrient.app.console.commands.kitchen;

import java.util.Arrays;
import java.util.List;

import com.nirmalsprojects.nutrient.app.console.commands.SubCommand;
import com.nirmalsprojects.nutrient.module.kitchen.IKitchenModule;

/**
 * Sub command to remove items from the kitchen
 */
public class KitchenRemoveCmd extends SubCommand {
	
	/**
	 * Command Name
	 */
	private static final String DEL_CMD = "remove";
	
	/**
	 * Command Description
	 */
	private static final String DESCRIPTION = "remove item from the kitchen";
	
	/**
	 * Command parameters
	 */
	private static final String[] params = new String[]{"userId", "itemName"};
	
	/**
	 * Kitchen Module
	 */
	IKitchenModule module;
	
	/**
	 * Constructor
	 * 
	 * @param module Kitchen Module
	 */
	public KitchenRemoveCmd(IKitchenModule module) {
		this.module = module;
	}

	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName() {
		return DEL_CMD;
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
			return module.removeItem(userId, itemName);
		} catch (Exception e) {
			// parsing error return false;
		}
		return false;
	}

}
