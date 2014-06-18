package ca.bcit.comp2613.quiltpad;

import ca.bcit.comp2613.a00192788.util.BlockUtil;
import ca.bcit.comp2613.a00192788.util.PieceUtil;
import ca.bcit.comp2613.a00192788.util.QuiltComparator;
import ca.bcit.comp2613.a00192788.util.QuiltUtil;
import ca.bcit.comp2613.a00192788.util.except.IllegalLengthException;
import ca.bcit.comp2613.a00192788.util.except.IllegalSizeException;
import ca.bcit.comp2613.a00192788.util.report.Report;
import ca.bcit.comp2613.quiltpad.model.Block;
import ca.bcit.comp2613.quiltpad.model.Piece;
import ca.bcit.comp2613.quiltpad.model.Quilt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestDriver {
	
	public static void main(String[] args) {
		// load logger //
		PropertyConfigurator.configure(
				TestDriver.class.getResourceAsStream("log4j.properties")
				);
		final Logger log = Logger.getLogger(TestDriver.class);
		
		Quilt quilt = new Quilt() {
			
			@Override
			// anonymous inner class overriding method //
			public void createQuilt() throws IllegalSizeException {
				
				Random rand = new Random();
				
				// make and print blocks //
				ArrayList<Block> blocks = BlockUtil.createBlocks();
				BlockUtil.printBlocks(blocks);
				
				// make and print pieces //
				ArrayList<Piece> pieces = PieceUtil.createPieces();
				PieceUtil.printPieces(pieces);	
				
				// make quilt by merging blocks and pieces //
				ArrayList<Quilt> quilts = QuiltUtil.mergeBlocks(blocks, pieces);
				
				// sort quilt list in ascending block quantity, and
				// then by descending quilt id //
				Collections.sort(quilts, new QuiltComparator());
				Report.printReport(quilts);
							
				// randomly generate exception 20% of the time //
				int randInt = rand.nextInt(100);
				if (randInt %5 == 0) {
					log.error("ERROR", new Exception("Generated 20% error - IllegalLengthException"));
					throw new IllegalLengthException();	
									}
				//  randomly generate exception 1% of the time //
				if (randInt == 1) {
					log.error("ERROR", new Exception("Generated 1% error - IllegalSizeException"));
					throw new IllegalSizeException();
						
				}		
			}
		};
			
		// main program //	
		try {
			quilt.createQuilt();		
		}
		catch (IllegalSizeException e) {
			e.printStackTrace(); 
		}	
		
	}
	
}