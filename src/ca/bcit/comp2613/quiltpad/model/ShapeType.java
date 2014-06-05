package ca.bcit.comp2613.quiltpad.model;

import java.util.Random;

/****************************************************************
 * ShapeType.java
 * 
 * This class defines an enum of the common shapes for the pieces
 * that make up a quilt block.
 * 
 * @author Sandra Buchanan
 * @date June 2014
 *
 ****************************************************************/


public enum ShapeType {
	SQR,			/* square */
	RECT,			/* rectangle */			
	HALFTRI, 		/* half-square triangle */
	QUARTTRI;		/* quarter-square triangle */
	
	
	/**************************************************************
	 * randomShape 
	 * This method generates a random enum value 
	 *
	 * @return ShapeType
	 **************************************************************/
	
	public static ShapeType randomShape() {
		Random rand = new Random();
		int index;
		
		index = rand.nextInt(ShapeType.values().length);
		return ShapeType.values()[index];		
	}
	
}
