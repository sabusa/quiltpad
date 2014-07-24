package ca.bcit.comp2613.quiltpad.model;

import ca.bcit.comp2613.a00192788.util.except.IllegalSizeException;

public class Quilt {
	
	private Integer id;
	private String blkName;
	private Integer blkQty;
	private Integer pieceQty;
	
	public Quilt() {
		super();
	}

	public Quilt(Integer id, String blkName, Integer pieceQty, Integer blkQty) {
		super();
		this.id = id;
		this.blkName = blkName;
		this.blkQty = blkQty;
		this.pieceQty = pieceQty;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBlkName() {
		return blkName;
	}

	public void setBlkName(String blkName) {
		this.blkName = blkName;
	}
	
	public Integer getBlkQty() {
		return blkQty;
	}

	public void setBlkQty(Integer blkQty) {
		this.blkQty = blkQty;
	}

	public Integer getPieceQty() {
		return pieceQty;
	}

	public void setPieceQty(Integer pieceQty) {
		this.pieceQty = pieceQty;
	}


	@Override
	public String toString() {
		return "Quilt [Id = " + id + ", Block Name = " + blkName + ", Piece Quantity = "
				+ pieceQty + ", Block Quantity = " + blkQty + "]";
	}

	public void createQuilt() throws IllegalSizeException {
		throw new IllegalSizeException();	
	}
			
}