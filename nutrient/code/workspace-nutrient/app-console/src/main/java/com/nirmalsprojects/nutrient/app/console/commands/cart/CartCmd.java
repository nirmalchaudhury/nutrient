package com.nirmalsprojects.nutrient.app.console.commands.cart;

import java.util.ArrayList;

import com.nirmalsprojects.nutrient.app.console.commands.Command;
import com.nirmalsprojects.nutrient.app.console.commands.ISubCommand;


public class CartCmd extends Command {
	
	public static final String CMD_NAME = "-cart";
	
	public static final String DESCRIPTION = "Use to modify shopping cart items";
	
	public CartCmd(ArrayList<ISubCommand> subCommands) {
		this.subCommands = subCommands;
	}
	
	public String getName()	{
		return CMD_NAME;
	}
	
	public String getDescription() {
		return DESCRIPTION;
	}

}
 