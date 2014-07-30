package ca.bcit.comp2613.a00192788.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;

import ca.bcit.comp2613.quiltpad.model.Block;

public class BlockUtil {
	
	private final static Integer MAX_QTY = 17;
	private final static Integer MAX_OBJS = 100;
	static Logger log = Logger.getLogger(BlockUtil.class);
	
	public static List<Block> createBlocks() {
		List<Block> retblocks = new ArrayList<Block>();
		Random rand = new Random();
		
		log.info("Creating random blocks");
		for (int i = 0; i < MAX_OBJS; i++) {
			Block block = new Block();
			
			// set all int properties of piece to random values //
			block.setBlkSize(rand.nextInt(MAX_QTY) + 1);
			block.setUniquePieces(rand.nextInt(MAX_OBJS) + 1);
			
			// set name to a random value //
			String randName = UUID.randomUUID().toString();
			block.setName(randName);
		
			retblocks.add(block);
		}
		return retblocks;		
	}	
	
	public static void printBlocks(List<Block> blocks) {
		for (Block block : blocks) {
			System.out.println(block);
		}		
	}
	
	public static void delete(List<Block> blocks, Block block) {
		Iterator<Block> iter = blocks.iterator();
		while (iter.hasNext()) {
			Block blockLoop = iter.next();
			if (blockLoop.getId().equals(block.getId())) {
				iter.remove();
				break;
			}
		}
	}

}


