package ca.bcit.comp2613.a00192788.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Grid extends JPanel{
	
	private final static int GRIDMAX = 480;
	private static final int PANESIZE = 520;
	private static final int OFFSET = 20;
	private static Integer gridSize;
	private static BufferedImage gridBackground;
	
	
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		drawGrid(gridSize);
		g2.drawImage(gridBackground, 0, 0, this);
	//	createOuterEdge(g2);
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
	/* 
	 * Draw a line along the block's edges
	 */
	private void createOuterEdge(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(OFFSET, OFFSET, GRIDMAX-2, GRIDMAX-2);
		g2.dispose();
	}
		
}

	


