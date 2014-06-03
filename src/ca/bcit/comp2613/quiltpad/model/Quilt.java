package ca.bcit.comp2613.quiltpad.model;

public class Quilt {
	
	private Integer id;
	private Integer blkQty;
	private Integer vBlkNo;
	private Integer hBlkNo;
	private Float qHeight;
	private Float qWidth;
		
	public Quilt() {
		super();
	}
	public Quilt(Integer id, Integer blkQty, Integer vBlkNo, Integer hBlkNo,
			Float qHeight, Float qWidth) {
		super();
		this.id = id;
		this.blkQty = blkQty;
		this.vBlkNo = vBlkNo;
		this.hBlkNo = hBlkNo;
		this.qHeight = qHeight;
		this.qWidth = qWidth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBlkQty() {
		return blkQty;
	}
	public void setBlkQty(Integer blkQty) {
		this.blkQty = blkQty;
	}
	public Integer getvBlkNo() {
		return vBlkNo;
	}
	public void setvBlkNo(Integer vBlkNo) {
		this.vBlkNo = vBlkNo;
	}
	public Integer gethBlkNo() {
		return hBlkNo;
	}
	public void sethBlkNo(Integer hBlkNo) {
		this.hBlkNo = hBlkNo;
	}
	public Float getqHeight() {
		return qHeight;
	}
	public void setqHeight(Float qHeight) {
		this.qHeight = qHeight;
	}
	public Float getqWidth() {
		return qWidth;
	}
	public void setqWidth(Float qWidth) {
		this.qWidth = qWidth;
	}
	@Override
	public String toString() {
		return "Quilt [Id = " + id + ", Block Quantity = " + blkQty + ", Vertical Block Numbers = " + vBlkNo
				+ ", Horizontal Block Numbers = " + hBlkNo + ", Quilt Height = " + qHeight + ", Quilt Width = "
				+ qWidth + "]";
	}


}
