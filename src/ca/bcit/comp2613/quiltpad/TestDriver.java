package ca.bcit.comp2613.quiltpad;

import ca.bcit.comp2613.a00192788.gui.BlockFrame;
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
import ca.bcit.comp2613.quiltpad.repository.BlockRepository;
import ca.bcit.comp2613.quiltpad.repository.PieceRepository;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class TestDriver {
	
	public static void main(String[] args) {
		
	//	ConfigurableApplicationContext context = SpringApplication.run(TestDriver.class); 
		// load logger //
	//	PropertyConfigurator.configure(
	//			TestDriver.class.getResourceAsStream("log4j.properties")
	//			);
	//	final Logger log = Logger.getLogger(TestDriver.class);
		
		
		Quilt quilt = new Quilt() {
			
			public void createQuilt() throws IllegalSizeException {
				ConfigurableApplicationContext context = SpringApplication.run(TestDriver.class);
				
		//		Random rand = new Random();
				BlockRepository blockRepository = context.getBean(BlockRepository.class);
				PieceRepository pieceRepository = context.getBean(PieceRepository.class);
				
				// create blocks //
				ArrayList<Block> blocks = BlockUtil.createBlocks();
				blockRepository.save(blocks);
				//BlockUtil.printBlocks(blocks);
				
				// create pieces //
				ArrayList<Piece> pieces = PieceUtil.createPieces();
				pieceRepository.save(pieces);
				//PieceUtil.printPieces(pieces);	
				
				PieceUtil.createMappingOfPiecesToBlocks(blocks, pieces);
				blockRepository.save(blocks);
				
				// make quilt by merging blocks and pieces //
				ArrayList<Quilt> quilts = QuiltUtil.mergeBlocks(blocks, pieces);
				
				// insert block
				Block block = new Block();
				block.setId(124);		
				block.setName("Windmill");
				block.setBlkSize(8);
				block.setUniquePieces(8);
				blockRepository.save(block); 
				
				context.close();
				
				
				// sort quilt list in ascending block quantity, and
				// then by descending quilt id //
				//Collections.sort(quilts, new QuiltComparator());
				//Report.printReport(quilts);
							
				// randomly generate exception 20% of the time //
		//		int randInt = rand.nextInt(100);
		//		if (randInt %5 == 0) {
		//			log.error("ERROR", new Exception("Generated 20% error - IllegalLengthException"));
		//			throw new IllegalLengthException();	
		//		}
				//  randomly generate exception 1% of the time //
		//		if (randInt == 1) {
		//			log.error("ERROR", new Exception("Generated 1% error - IllegalSizeException"));
		//			throw new IllegalSizeException();
		//		}		
			}
		};
			
		// main program //	
		try {
			quilt.createQuilt();		
		}
		catch (IllegalSizeException e) {
			e.printStackTrace(); 
		}	

		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BlockFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
}