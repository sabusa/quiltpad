package ca.bcit.comp2613.a00192788.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel{
	
	private final static int GRIDMAX = 480;
	private static final int PANESIZE = 520;
	private static final int OFFSET = 20;
	private static Integer gridSize;
	private static BufferedImage gridBackground;
	
	
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		if (gridBackground == null)
			drawGrid(gridSize);
		g2.drawImage(gridBackground, 0, 0, this);
	}
	
	 @Override
	  public Dimension getPreferredSize(){
	    return new Dimension(PANESIZE, PANESIZE);
	  }
	
	 /* 
	  * Draw the grid lines for the specified grid size
	  * */  
	public static void drawGrid (Integer gridSize) {
		Graphics2D g2;
		gridBackground = new BufferedImage (PANESIZE, PANESIZE, BufferedImage.TYPE_INT_RGB);
		g2 = gridBackground.createGraphics();
		g2.setPaint (UIManager.getColor("Panel.background"));
		g2.fillRect (0, 0, PANESIZE, PANESIZE);
			
		// create grid lines
		g2.setColor(Color.LIGHT_GRAY);
		for (int i=OFFSET; i<PANESIZE+OFFSET; i+=gridSize) {
			g2.drawLine(i, OFFSET, i, PANESIZE-OFFSET);  // draw vertical lines
			g2.drawLine(OFFSET, i, PANESIZE-OFFSET, i);  // draw horizontal lines
		}
		g2.dispose();
	}
	
	 /* 
     * Determine grid size based on block size for best fit in panel
     */ 
	public static Integer calcGrid(Integer blkSize) {
    	return gridSize = GRIDMAX / blkSize;
	}
	
	public Point goToClosestNode(Point p) {
		int xInter;
		int yInter;
		
		int x = (int) p.getX() - OFFSET;
		int y = (int) p.getY() - OFFSET;
		int modX = x % gridSize;
		int modY = y % gridSize;
	            
		// determine the nearest grid x-intersect to mouse
		if (modX < gridSize/2) {
			xInter = x - modX;  // move left on x-axis
		}
		else {
			xInter = x + (gridSize-modX);  // move right on x-axis
		}
		// determine the nearest grid y-intercept to mouse
		if (modY < gridSize/2) {
			yInter = y - modY;  // move up on y-axis
		}
		else {
			yInter = y + (gridSize-modY);  // move down on y-axis
		}
			
		return new Point(xInter + OFFSET, yInter + OFFSET);
	}
	
	 /* 
     * Draw a circle around the closest node to the mouse
     */ 
	public void circleNode(Point p) {
		// show the closest intersection point
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setColor(Color.BLACK);
		
		// check to see point is within panel
		if ((p.x>=0 && p.x<=PANESIZE) && (p.y>=0 && p.y<=PANESIZE)) {
			
		//draw circle
		g2.drawOval(p.x-4, p.y-4, 8, 8);
		g2.dispose();
		}
	}

	public void drawPiece(Point startP, Point stopP) {
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(startP.x, startP.y, stopP.x, stopP.y);
	}	
		
}

	


