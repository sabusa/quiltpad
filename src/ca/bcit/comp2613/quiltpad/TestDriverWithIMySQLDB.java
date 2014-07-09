package ca.bcit.comp2613.quiltpad;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import ca.bcit.comp2613.quiltpad.model.Block;
import ca.bcit.comp2613.quiltpad.repository.BlockRepository;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class TestDriverWithIMySQLDB {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestDriverWithIMySQLDB.class); 
		
		BlockRepository blockRepository = context.getBean(BlockRepository.class);
		
		Block block = new Block();
		block.setId(124);		
		block.setName("Windmill");
		block.setBlkSize(8);
		block.setUniquePieces(8);
		blockRepository.save(block); 
		
		context.close();
		
	}
}
