package ca.bcit.comp2613.a00192788.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import ca.bcit.comp2613.quiltpad.model.BlkLine;

public class DrawBlock extends JPanel{
	ArrayList<BlkLine> blkLines;
	
	public DrawBlock(ArrayList<BlkLine> blkLines) {
		this.blkLines = blkLines;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		redrawBlkLines(g2, blkLines);
		
	}

	public void redrawBlkLines(Graphics2D g2, ArrayList<BlkLine> blkLines) {
		for (BlkLine blkLine : blkLines) {
			Point startPt = blkLine.getStartPt();
			Point stopPt = blkLine.getStopPt();
			drawBlkLine(g2, startPt, stopPt);
		}
	}
	
	public void drawBlkLine(Graphics2D g2, Point startPt, Point stopPt) {
	//	Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(startPt.x, startPt.y, stopPt.x, stopPt.y);
	}
	
	
}
