package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.app.console.commands.Command;
import com.nirmalsprojects.nutrient.app.console.commands.ISubCommand;

/**
 * Shopping cart command
 * 
 * @author Nirmal
 *
 */
public class CartCmd extends Command {
	
	public static final String CMD_NAME = "-cart";
	
	public static final String DESCRIPTION = "Use to modify shopping cart items";
	
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
 