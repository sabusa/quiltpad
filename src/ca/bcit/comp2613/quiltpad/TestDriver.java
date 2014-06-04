package ca.bcit.comp2613.quiltpad;

import ca.bcit.comp2613.a00192788.util.PieceUtil;
import ca.bcit.comp2613.a00192788.util.except.IllegalLengthException;
import ca.bcit.comp2613.a00192788.util.except.IllegalSizeException;
import ca.bcit.comp2613.quiltpad.model.Block;
import ca.bcit.comp2613.quiltpad.model.Piece;

import java.util.ArrayList;
import java.util.Random;

public class TestDriver {
	
	public static void main(String[] args) {
		Block block = new Block() {
			
			@Override
			// anonymous inner class overriding method //
			public void pieceChecker() throws IllegalSizeException {
				Random rand = new Random();
		
				ArrayList<Piece> pieces = PieceUtil.createPieces();
		
				// randomly generate exception 20% of the time //
				try{
					int randInt = rand.nextInt();
					if (randInt %5 == 0) {
						System.out.println("Not a valid length");
						throw new IllegalLengthException();	
					}
				}
				catch (IllegalLengthException e) {
					System.out.println("Generated exception!");
				}
				// test bad vertical length of "1" which occurs 1% of the time //
				finally {
					pieces = PieceUtil.searchLength(pieces,1);
					//PieceUtil.printPieces(pieces);
				}
			}	
		};
			
			try {
				block.pieceChecker();
			}
			catch (IllegalSizeException e) {			
				e.printStackTrace(); 
		}
		
	}

	
}