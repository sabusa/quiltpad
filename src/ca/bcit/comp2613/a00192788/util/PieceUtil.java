package ca.bcit.comp2613.a00192788.util;

import ca.bcit.comp2613.quiltpad.model.Piece;

import java.util.ArrayList;
import java.util.Random;

public class PieceUtil {
	private final static Integer MAX_LENGTH = 16;
	private final static Integer MAX_HYP = 24;
	private final static Integer MAX_OBJS = 100;
	
	public static ArrayList<Piece> createPieces() {
		ArrayList<Piece> retpieces = new ArrayList<>();
		Random rand = new Random();
	
		int pieceQty = rand.nextInt(MAX_OBJS);
		System.out.println(pieceQty);
		for (int i = 0; i < pieceQty; i++) {
			Piece piece = new Piece();
			piece.setId(i);
			piece.setType(rand.nextInt(5));
			piece.setValue(rand.nextInt(3));
			piece.setPosition(null);
			if (piece.getType() < 3){
				piece.sethSideLength(rand.nextInt(MAX_LENGTH));
				piece.setvSideLength(rand.nextInt(MAX_LENGTH));
			}
			else {
				piece.setaSideLength(rand.nextInt(MAX_LENGTH));
				piece.setbSideLength(rand.nextInt(MAX_LENGTH));
				piece.setcSideLength(rand.nextInt(MAX_HYP));
			}
			retpieces.add(piece);
		}
		return retpieces;	
	}
	
	public static void printPieces(ArrayList<Piece> pieces) {
		for (Piece piece : pieces) {
			System.out.println(piece);
		}
	}
}
