package ca.bcit.comp2613.quiltpad.model;

import java.awt.Point;

public class Piece {
	
	private Integer id;
	private Integer type;
	private Integer value;
	private Point position;
	private Integer vSideLength;
	private Integer hSideLength;
	private Integer aSideLength;
	private Integer bSideLength;
	private Integer cSideLength;	
	
	public Piece() {
		super();
	}
	public Piece(Integer id, Integer type, Integer value, Point position,
			Integer vSideLength, Integer hSideLength, Integer aSideLength,
			Integer bSideLength, Integer cSideLength) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
		this.position = position;
		this.vSideLength = vSideLength;
		this.hSideLength = hSideLength;
		this.aSideLength = aSideLength;
		this.bSideLength = bSideLength;
		this.cSideLength = cSideLength;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public Integer getvSideLength() {
		return vSideLength;
	}
	public void setvSideLength(Integer vSideLength) {
		this.vSideLength = vSideLength;
	}
	public Integer gethSideLength() {
		return hSideLength;
	}
	public void sethSideLength(Integer hSideLength) {
		this.hSideLength = hSideLength;
	}
	public Integer getaSideLength() {
		return aSideLength;
	}
	public void setaSideLength(Integer aSideLength) {
		this.aSideLength = aSideLength;
	}
	public Integer getbSideLength() {
		return bSideLength;
	}
	public void setbSideLength(Integer bSideLength) {
		this.bSideLength = bSideLength;
	}
	public Integer getcSideLength() {
		return cSideLength;
	}
	public void setcSideLength(Integer cSideLength) {
		this.cSideLength = cSideLength;
	}
	@Override
	public String toString() {
		return "Piece [Id = " + id + ", Type = " + type + ", Value = " + value
				+ ", Position = " + position + ", Vertical Side Length = " + vSideLength
				+ ", Horizontal Side Length = " + hSideLength + ", A Side Length = "
				+ aSideLength + ", B Side Length = " + bSideLength
				+ ", C Side Length = " + cSideLength + "]";
	}
	
	
}
