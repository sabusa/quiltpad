package ca.bcit.comp2613.a00192788.util;

import java.util.ArrayList;

import ca.bcit.comp2613.quiltpad.model.Block;
import ca.bcit.comp2613.quiltpad.model.Piece;
import ca.bcit.comp2613.quiltpad.model.Quilt;

public class MakeQuilt {
	
	
	
	public static ArrayList<Quilt> mergeBlocks(ArrayList<Block> blocks, ArrayList<Piece> pieces) {
		ArrayList<Quilt> newQuilt = new ArrayList<>();
		int largeSize = 50;
		int i = 0;
		
		// make quilt when number of pieces are even and vertical length is over 50 //
		Quilt quilt = new Quilt();
		for (Block block : blocks) {
			for (Piece piece : pieces) {
				if ((block.getUniquePieceQty() %2 == 0) && 
						(piece.getvSideLength() > largeSize)) {
					
					// set quilt properties //
					System.out.println (i);
					quilt.setId(i+1);
					quilt.setBlkName(block.getName());
					quilt.setBlkQty(block.getBlkQty());
					quilt.setPieceQty(block.getUniquePieceQty());
					i++;
					
					newQuilt.add(quilt);
				}
			}
		}
		
		return newQuilt;
	}
}
