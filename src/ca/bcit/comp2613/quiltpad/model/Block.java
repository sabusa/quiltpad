package ca.bcit.comp2613.quiltpad.model;

public class Block {

	private Integer id;
	private String name;
	private Integer uniquePieceQty;
	private Integer blkSize;	
	
	public Block() {
		super();
	}
	public Block(Integer id, String name, Integer uniquePieceQty, Integer blkSize) {
		super();
		this.id = id;
		this.name = name;
		this.uniquePieceQty = uniquePieceQty;
		this.blkSize = blkSize;
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
	public Integer getBlkSize() {
		return blkSize;
	}
	public void setBlkSize(Integer blkSize) {
		this.blkSize = blkSize;
	}
	@Override
	public String toString() {
		return "Block [Id = " + id + ", Name = " + name + ", Unique Piece Quantity ="
				+ uniquePieceQty + ", Block Size = " + blkSize + "]";
	}

}
