package ca.bcit.comp2613.quiltpad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ca.bcit.comp2613.a00192788.gui.BlockFrame;
import ca.bcit.comp2613.a00192788.util.BlockUtil;
import ca.bcit.comp2613.a00192788.util.PieceUtil;
import ca.bcit.comp2613.quiltpad.model.Block;
import ca.bcit.comp2613.quiltpad.model.Piece;
import ca.bcit.comp2613.quiltpad.repository.BlockRepository;
import ca.bcit.comp2613.quiltpad.repository.CustomQueryHelper;
import ca.bcit.comp2613.quiltpad.repository.PieceRepository;


public class QuiltPad {
	public static boolean useInMemoryDB = true;
	public static List<Block> blocks;
	public static List<Piece> pieces;
	public static BlockRepository blockRepository;
	public static PieceRepository pieceRepository;
	public static CustomQueryHelper customQueryHelper;
	
	public QuiltPad () {
		ConfigurableApplicationContext context = null;
		if (useInMemoryDB) {
			context = SpringApplication.run(H2Config.class);
			try {
				org.h2.tools.Server.createWebServer(null).start();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			context = SpringApplication.run(MySQLConfig.class);
		}

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		EntityManagerFactory emf = (EntityManagerFactory) context
				.getBean("entityManagerFactory");

		blockRepository = context.getBean(BlockRepository.class);
		pieceRepository = context.getBean(PieceRepository.class);
		
		// create blocks //
		List<Block> blocks = BlockUtil.createBlocks();
		blockRepository.save(blocks);
		
		// create pieces //
		List<Piece> pieces = PieceUtil.createPieces();
		pieceRepository.save(pieces);
		
		customQueryHelper = new CustomQueryHelper(emf);
		blocks = copyIterator(blockRepository.findAll().iterator());
		pieces = copyIterator(pieceRepository.findAll().iterator());
				
		new BlockFrame();
	}

	public static <T> List<T> copyIterator(Iterator<T> iter) {
		List<T> copy = new ArrayList<T>();
		while (iter.hasNext())
			copy.add(iter.next());
		return copy;
	}
	
}
	
