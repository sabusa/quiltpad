package ca.bcit.comp2613.a00192788.util;

import ca.bcit.comp2613.a00192788.util.except.IllegalSizeException;
import ca.bcit.comp2613.quiltpad.model.Piece;
import ca.bcit.comp2613.quiltpad.model.ShapeType;
import ca.bcit.comp2613.quiltpad.model.FabricValue;

import java.util.ArrayList;
import java.util.Random;

public class PieceUtil {
	private final static Integer MAX_LENGTH = 100;
	private final static Integer MAX_HYP = 24;
	private final static Integer MAX_OBJS = 100;	
	
	public static ArrayList<Piece> createPieces() {
		ArrayList<Piece> retpieces = new ArrayList<>();
		Random rand = new Random();
		ShapeType shape; 
	
		for (int i = 0; i < MAX_OBJS; i++) {
			Piece piece = new Piece();
			piece.setId(i+1);
			piece.setsType(ShapeType.values()[rand.nextInt(ShapeType.values().length)]);
			piece.setfValue(FabricValue.values()[rand.nextInt(FabricValue.values().length)]);
			piece.setPosition(null);
			shape = piece.getsType();
			if ((shape == ShapeType.SQR)||(shape == ShapeType.RECT)) {
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
	
	public static ArrayList<Piece> searchLength(ArrayList<Piece> pieces, 			
			int lengthValue) throws IllegalSizeException {
		
		ArrayList<Piece> retpieces = new ArrayList<>();
		for (Piece piece : pieces) {
			if (piece.getvSideLength() != lengthValue) {
				retpieces.add(piece);
			}
			else {
				throw new IllegalSizeException();
			}
		}
		return retpieces;
	}

	public static void searchLengthMin(ArrayList<Piece> pieces) {
		
		for (Piece piece : pieces) {
			if (piece.getvSideLength() == 1) {
				System.out.println(piece);
			}	
		}
	}
}
