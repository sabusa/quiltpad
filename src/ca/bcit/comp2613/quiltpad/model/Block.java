package ca.bcit.comp2613.quiltpad.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer blkSize;
	private Integer uniquePieces;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "block_piece",
	joinColumns = { @JoinColumn(name = "block_id") }, inverseJoinColumns = 
					{ @JoinColumn(name = "piece_id") })
	private List<Piece> pieces;
		
		
	public Block() {
		super();
	}
	public Block(Integer id, String name, Integer blkSize, Integer uniquePieces) {
		//super();
		this.id = id;
		this.name = name;
		this.blkSize = blkSize;
		this.uniquePieces = uniquePieces;
	
	}
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getBlkSize() {
		return blkSize;
	}
	public void setBlkSize(Integer size) {
		this.blkSize = size;
	}
	
	public Integer getUniquePieces() {
		return uniquePieces;
	}
	public void setUniquePieces(Integer uniquePieces) {
		this.uniquePieces = uniquePieces;
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
	
	@Override
	public String toString() {
		return "Block [Id = " + id + ", Name = " + name + ", Size = " +
				blkSize + ", Unique Pieces = "+ uniquePieces + "]";
	}
	


}
