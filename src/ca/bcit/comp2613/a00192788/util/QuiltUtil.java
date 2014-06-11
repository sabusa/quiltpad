package ca.bcit.comp2613.a00192788.util;

import java.util.ArrayList;
import java.util.Comparator;

import ca.bcit.comp2613.quiltpad.model.Block;
import ca.bcit.comp2613.quiltpad.model.Piece;
import ca.bcit.comp2613.quiltpad.model.Quilt;

public class QuiltUtil {
		

	public static ArrayList<Quilt> mergeBlocks(ArrayList<Block> blocks, ArrayList<Piece> pieces) {
		ArrayList<Quilt> newQuilt = new ArrayList<Quilt>();
		int largeSize = 50;
		int i = 0;
			
		// make quilt when number of pieces are even and vertical length is over 50 //
		for (Block block : blocks) {
			if (block.getUniquePieceQty() %2 == 0) {
				for (Piece piece : pieces) {
					if (piece.getvSideLength() > largeSize) {
		
						Quilt quilt = new Quilt();
						
						// set quilt properties //
						quilt.setId(i+1);
						quilt.setBlkName(block.getName());
						quilt.setBlkQty(block.getBlkQty());
						quilt.setPieceQty(block.getUniquePieceQty());
						i++;
						
						newQuilt.add(quilt);
					}
				}
			}
		}
			
		return newQuilt;
	
	}

	public static class QuiltComparator implements Comparator<Quilt> {
		@Override
		public int compare(Quilt quilt1, Quilt quilt2) {
			int result;
			result = quilt1.getBlkQty() - quilt2.getBlkQty();
			if (result == 0) {
				return quilt2.getId().compareTo(quilt2.getId());
			}
			else {
				return result;
			}
		}

	}
}
