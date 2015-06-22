package com.nirmalsprojects.nutrient.app.console.commands;

import java.util.List;

public interface ISubCommand extends ICommand {
	
	List<String> getParameters();

}
