package ca.bcit.comp2613.quiltpad.model;

public class Quilt {
	
	private Integer blkQty;
	private Integer vBlkNo;
	private Integer hBlkNo;
	private Float qHeight;
	private Float qWidth;	

	public Quilt(Integer blkQty, Integer vBlkNo, Integer hBlkNo, Float qHeight,
			Float qWidth) {
		super();
		this.blkQty = blkQty;
		this.vBlkNo = vBlkNo;
		this.hBlkNo = hBlkNo;
		this.qHeight = qHeight;
		this.qWidth = qWidth;
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

}
