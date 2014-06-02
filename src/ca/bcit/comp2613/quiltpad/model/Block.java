package ca.bcit.comp2613.quiltpad.model;

public class Block {

	private String name;
	private Integer uniquePieceQty;
	private Integer blkSize;
	
	
	public Block(String name, Integer uniquePieceQty, Integer blkSize) {
		super();
		this.name = name;
		this.uniquePieceQty = uniquePieceQty;
		this.blkSize = blkSize;
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
	public Integer getBlkSize() {
		return blkSize;
	}
	public void setBlkSize(Integer blkSize) {
		this.blkSize = blkSize;
	}

}
