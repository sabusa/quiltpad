package ca.bcit.comp2613.a00192788.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import ca.bcit.comp2613.quiltpad.model.BlkLine;

public class BlkLineUtil extends JPanel {
	private static final int PANESIZE = 520;
	private Point startPt;
	private Point stopPt;
	private ArrayList<BlkLine> blkLines;

	public BlkLineUtil() {
		super();
	}
	
	public BlkLineUtil(ArrayList<BlkLine> blkLines) {
		this.blkLines = blkLines;
	}
	
	public BlkLineUtil(Point startPt, Point stopPt) {
		this.startPt = startPt;
		this.stopPt = stopPt;
	}
		
	public BlkLineUtil(ArrayList<BlkLine> blkLines, Point startPt, Point stopPt) {
		this.startPt = startPt;
		this.stopPt = stopPt;
		this.blkLines = blkLines;
		
	}
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
//		g2.setColor(Color.BLACK);
//		g2.setStroke(new BasicStroke(3));
//		g2.drawLine(startPt.x, startPt.y, stopPt.x, stopPt.y);
//		g2.dispose();
//		
	}
	
	 @Override
	  public Dimension getPreferredSize(){
	    return new Dimension(PANESIZE, PANESIZE);
	  }

	public ArrayList<BlkLine> addBlkLine(ArrayList<BlkLine> blkLines,
							Point startPt, Point stopPt) {
		ArrayList<BlkLine> retval = blkLines;
		retval.add(new BlkLine(startPt, stopPt));
		return retval;
	}

	public ArrayList<BlkLine> removeBlkLine(ArrayList<BlkLine> blkLines) {
		ArrayList<BlkLine> retval = blkLines;
		retval.remove(blkLines.size() - 1);
		return retval;
	}

	public void redrawBlkLines(ArrayList<BlkLine> blkLines) {
		for (int i=0; i<blkLines.size(); i++) {
			Point startPt = blkLines.get(i).getStartPt();
			Point stopPt = blkLines.get(i).getStopPt();
			new BlkLineUtil(startPt, stopPt);
		}	
	}
		
	public void drawBlkLine(Point startPt, Point stopPt) {
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(startPt.x, startPt.y, stopPt.x, stopPt.y);
		g2.dispose();
	}	
}
