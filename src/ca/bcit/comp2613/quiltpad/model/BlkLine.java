package ca.bcit.comp2613.quiltpad.model;

import java.awt.Point;

public class BlkLine {
	
	Point startPt;
	Point stopPt;
	
	public BlkLine() {
		super();
	}

	public BlkLine(Point startPt, Point stopPt) {
		this.startPt = startPt;
		this.stopPt = stopPt;
	}

	public Point getStartPt() {
		return startPt;
	}

	public void setStartPt(Point startPt) {
		this.startPt = startPt;
	}

	public Point getStopPt() {
		return stopPt;
	}

	public void setStopPt(Point stopPt) {
		this.stopPt = stopPt;
	}
	
	
}
