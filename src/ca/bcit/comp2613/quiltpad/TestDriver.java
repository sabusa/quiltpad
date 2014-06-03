package ca.bcit.comp2613.quiltpad;

import ca.bcit.comp2613.a00192788.util.PieceUtil;
import ca.bcit.comp2613.quiltpad.model.Piece;
import java.util.ArrayList;

public class TestDriver {
	
	public static void main(String[] args) {
		ArrayList<Piece> pieces = PieceUtil.createPieces();
		PieceUtil.printPieces(pieces);
			
	}

}
