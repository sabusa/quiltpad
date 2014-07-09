package ca.bcit.comp2613.quiltpad.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import ca.bcit.comp2613.quiltpad.model.Block;

public interface BlockRepository extends CrudRepository<Block, Integer> {

	ArrayList<Block> findByName(String name);
	
}
