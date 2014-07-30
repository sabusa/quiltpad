package ca.bcit.comp2613.quiltpad.model;

import java.util.Random;

/****************************************************************
 * FabricValue.java
 * 
 * This class defines an enum of the three types of fabric values.
 * 
 * @author Sandra Buchanan
 * @date June 2014
 *
 ****************************************************************/

public enum FabricValue {
	LIGHT, MEDIUM, DARK;
	
	/**************************************************************
	 * randomValue 
	 * This method generates a random enum value 
	 *
	 * @return FabricValue
	 **************************************************************/
	
	public static FabricValue randomValue() {
		Random rand = new Random();
		int index;
		
		index = rand.nextInt(FabricValue.values().length);
		return FabricValue.values()[index];		
	}
	
}
