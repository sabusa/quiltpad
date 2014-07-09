package ca.bcit.comp2613.quiltpad.model;


public class Block {

	private Integer id;
	private String name;
	private Integer blkSize;
	private Integer uniquePieces;
	
	
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
	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Block [Id = " + id + ", Name = " + name + ", Size = " +
				blkSize + "Unique Pieces = "+ uniquePieces + "]";
	}
	


}
