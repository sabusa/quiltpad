package ca.bcit.comp2613.quiltpad.model;

import java.awt.Point;

public class BlkLines {
	
	Point startPt;
	Point stopPt;
	
	public BlkLines() {
		super();
	}

	public BlkLines(Point startPt, Point stopPt) {
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
