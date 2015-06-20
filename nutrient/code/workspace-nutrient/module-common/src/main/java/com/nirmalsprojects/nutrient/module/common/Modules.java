package com.nirmalsprojects.nutrient.module.common;

import java.util.ArrayList;

/**
 * Container for all the available modules
 * @author Nirmal
 *
 */
public class Modules {
    
	/**
	 * Array of all the modules
	 */
	private ArrayList<IModule> modules;
	
	/**
	 * Constructor
	 * 
	 * @param modules list of all the available modules
	 */
	public Modules(ArrayList<IModule> modules) {
		this.modules = modules;
	}
	
	/**
	 * Returns the list of modules
	 * @return list of modules
	 */
	public ArrayList<IModule> getModules() {
		return modules;
	}
	
	/**
	 * Gets the module of a specific type
	 * 
	 * @param moduleType desired module type
	 * @return desired module type if available, null otherwise
	 */
	public IModule getModule(ModuleType moduleType) {
		for (IModule module : modules) {
			if (module.getModuleType() == moduleType) {
				return module;
			}
		}
		return null;
	}
	
}
