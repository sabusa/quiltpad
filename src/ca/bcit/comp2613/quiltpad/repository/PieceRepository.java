package ca.bcit.comp2613.quiltpad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.bcit.comp2613.quiltpad.model.Piece;

public interface PieceRepository extends CrudRepository<Piece, Integer> {

	@Query("select b from Piece b where b.blkName = :blkName")
	Piece findByBlkName(@Param("blkName") String blkName);
}
