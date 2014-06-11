package ca.bcit.comp2613.a00192788.util;

import java.util.Comparator;

import ca.bcit.comp2613.quiltpad.model.Quilt;

/****************************************************************
 * QuiltComparator.java
 * 
 * This class implements Comparator and overrides the compare method 
 * by sorting the quilts first in descending Block Quantity order and 
 * then in ascending order by Quilt Id number (by using the standard
 * Comparable compareTo method).
 * 
 * @author Sandra Buchanan
 * @date June 2014
 *
 ****************************************************************/

public class QuiltComparator implements Comparator<Quilt> {
	
	/**************************************************************
	 * compare 
	 * Overridden method
	 *
	 * @param quilt1, quilt2 (2 Quilt objects)
	 * @return result (int based on comparison)
	 **************************************************************/
	@Override
	public int compare(Quilt quilt1, Quilt quilt2) {
		int result;
		result = quilt2.getBlkQty() - quilt1.getBlkQty();
		if (result == 0) {
			return quilt1.getId().compareTo(quilt1.getId());
		}
		else {
			return result;
		}
	}

}

