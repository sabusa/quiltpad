package ca.bcit.comp2613.quiltpad.model;

import java.awt.Point;
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
public class Piece {
	
	@Id
	private Integer id;
	private String blkName;
	private ShapeType sType; 
	private FabricValue fValue;
	private Integer pQty;
	private Point position;
	private Integer vSideLength;   
	private Integer hSideLength;
	private Integer aSideLength;
	private Integer bSideLength;
	private Integer cSideLength;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "block_piece",
	joinColumns = { @JoinColumn(name = "piece_id") }, inverseJoinColumns =
					{ @JoinColumn(name = "block_id") })
	private List<Block> blocks;
	
	
	public Piece() {
		super();
	}
	
	public Piece(String blkName, Integer id, ShapeType sType, FabricValue fValue, 
			Integer pQty, Point position, Integer vSideLength, Integer hSideLength,
			Integer aSideLength, Integer bSideLength, Integer cSideLength) {
		super();
		this.blkName = blkName;
		this.id = id;
		this.sType = sType;
		this.fValue = fValue;
		this.pQty = pQty;
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

	public String getBlkName() {
		return blkName;
	}
	public void setBlkName(String blkName) {
		this.blkName = blkName;
	}
	
	public ShapeType getsType() {
		return sType;
	}
	public void setsType(ShapeType sType) {
		this.sType = sType;
	}
	
	public FabricValue getfValue() {
		return fValue;
	}
	public void setfValue(FabricValue fValue) {
		this.fValue = fValue;
	}
	
	public Integer getpQty() {
		return pQty;
	}
	public void setpQty(Integer pQty) {
		this.pQty = pQty;
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
	
	public List<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	@Override
	public String toString() {
		return "Block Name = " + blkName + ", Id = " + id + ", Type=" + sType 
				+ ", Fabric Value = " + fValue + ", Position = " + position 
				+ ", Vertical Length = " + vSideLength + ", Horizontal Length = "
				+ hSideLength + ", A Side Length = " + aSideLength 
				+ ", B Side Length = " + bSideLength + ", C Side Length = " 
				+ cSideLength ;
	}
	
	
}
