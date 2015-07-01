package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.app.console.commands.Command;
import com.nirmalsprojects.nutrient.app.console.commands.ISubCommand;

/**
 * Shopping cart command
 */
public class CartCmd extends Command {
	
	/**
	 * Command Name
	 */
	public static final String CMD_NAME = "-cart";
	
	/**
	 * Command Description
	 */
	public static final String DESCRIPTION = "Use to modify shopping cart items";
	
	/**
	 * Constructor
	 * 
	 * @param subCommands supported subcommands
	 */
	public CartCmd(ArrayList<ISubCommand> subCommands) {
		this.subCommands = subCommands;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getName()
	 */
	public String getName()	{
		return CMD_NAME;
	}
	
	/**
	 * @see com.nirmalsprojects.nutrient.app.console.commands.ICommand#getDescription()
	 */
	public String getDescription() {
		return DESCRIPTION;
	}

}
 