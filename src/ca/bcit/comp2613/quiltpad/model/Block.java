package ca.bcit.comp2613.quiltpad.model;

import ca.bcit.comp2613.a00192788.util.except.IllegalSizeException;

public class Block {

	private Integer id;
	private String name;
	private Integer uniquePieceQty;
	private Integer blkQty;	
	
	public Block() {
		super();
	}
	public Block(Integer id, String name, Integer uniquePieceQty, Integer blkSize) {
		super();
		this.id = id;
		this.name = name;
		this.uniquePieceQty = uniquePieceQty;
		this.blkQty = blkSize;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUniquePieceQty() {
		return uniquePieceQty;
	}
	public void setUniquePieceQty(Integer uniquePieceQty) {
		this.uniquePieceQty = uniquePieceQty;
	}
	public Integer getBlkQty() {
		return blkQty;
	}
	public void setBlkQty(Integer blkQty) {
		this.blkQty = blkQty;
	}
	@Override
	public String toString() {
		return "Block [Id = " + id + ", Name = " + name + ", Unique Piece Quantity ="
				+ uniquePieceQty + ", Block Quantity = " + blkQty + "]";
	}
	


}
