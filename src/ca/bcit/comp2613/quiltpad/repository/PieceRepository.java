package ca.bcit.comp2613.quiltpad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.bcit.comp2613.quiltpad.model.Piece;
import ca.bcit.comp2613.quiltpad.model.ShapeType;

public interface PieceRepository extends CrudRepository<Piece, Integer> {

	@Query("select t from Piece where t.stype = :stype")
	Piece findByType(ShapeType stype);
}
