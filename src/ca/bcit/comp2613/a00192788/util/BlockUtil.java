package ca.bcit.comp2613.a00192788.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import ca.bcit.comp2613.quiltpad.model.Block;

public class BlockUtil {
	
	private final static Integer MAX_QTY = 17;
	private final static Integer MAX_OBJS = 100;
	
	public static ArrayList<Block> createBlocks() {
		ArrayList<Block> retblocks = new ArrayList<Block>();
		Random rand = new Random();
	
		for (int i = 0; i < MAX_OBJS; i++) {
			Block block = new Block();
			
			// set all int properties of piece to random values //
			block.setId(i+1);
			block.setBlkQty(rand.nextInt(MAX_QTY));
			block.setUniquePieceQty(rand.nextInt(MAX_OBJS));
			
			// set name to a random value //
			String randName = UUID.randomUUID().toString();
			block.setName(randName);
		
			retblocks.add(block);
		}
		return retblocks;		
	}	

	public static void printBlocks(ArrayList<Block> blocks) {
		for (Block block : blocks) {
			System.out.println(block);
		}		
	}

}

