
package ca.bcit.comp2613.a00192788.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import ca.bcit.comp2613.quiltpad.model.BlkLine;


@SuppressWarnings("serial")
public class DrawPiece extends JPanel{

	private static final int OFFSET = 27;
	private final int PANESIZE = 520;	
	private Point startPt, stopPt;
	private Integer gridSize;
	private Integer blkSize;
	private static ArrayList<BlkLine> blkLines;
	
	public DrawPiece(Integer grid, Integer blk, ArrayList<BlkLine> lines) {
	//	setPreferredSize(new Dimension(PANESIZE, PANESIZE));
		blkLines = lines;
		gridSize = grid;
		blkSize = blk;
		// add grid
		add(new Grid(gridSize, blkSize));
//		for(BlkLine blkLine : blkLines){
//			System.out.println(blkLine.getStartPt());
//		}
//		if (!blkLines.isEmpty()) {
//			redrawBlkLines(blkLines);
//		}
				
		addMouseListener(new MouseListener() {     	  
			public void mousePressed(MouseEvent e) {
				// go to closest node from mouse pressed to start line
				startPt = goToClosestNode(e.getPoint());
				circleNode(startPt);
			//	repaint();
  			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// go to closest node from mouse pressed to start line
				stopPt = goToClosestNode(e.getPoint());
				circleNode(stopPt);
				drawBlkLine(startPt, stopPt);
				blkLines = addBlkLine(blkLines, startPt, stopPt);
			}



			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
		
	public Point goToClosestNode(Point pt) {
		int xInter;
		int yInter;
		
		int x = (int) pt.getX() - OFFSET;
		int y = (int) pt.getY() - OFFSET;
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
			
		return new Point(xInter+OFFSET, yInter+OFFSET);
	}
	
	 /* 
     * Draw a circle around the closest node to the mouse
     */ 
	public void circleNode(Point pt) {
		// show the closest intersection point
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setColor(Color.BLACK);
		
		// check to see point is within panel
		if ((pt.x>=0 && pt.x<=PANESIZE) && (pt.y>=0 && pt.y<=PANESIZE)) {
			
		//draw circle
		g2.drawOval(pt.x-4, pt.y-4, 8, 8);
		g2.dispose();
		}
	}

	public ArrayList<BlkLine> addBlkLine(ArrayList<BlkLine> blkLines,
											Point startPt, Point stopPt) {
		ArrayList<BlkLine> retval = blkLines;
		blkLines.add(new BlkLine(startPt, stopPt));
		return retval;
	}
	
	public static ArrayList<BlkLine> removeBlkLine(ArrayList<BlkLine> blkLines) {
		ArrayList<BlkLine> retval = blkLines;
		blkLines.remove(blkLines.size() - 1);
		return retval;
	}
	
	/*public void redrawBlkLines(Graphics2D g2, ArrayList<BlkLine> blkLines) {
		for (BlkLine blkLine : blkLines) {
			Point startPt = blkLine.getStartPt();
			Point stopPt = blkLine.getStopPt();
			drawBlkLine(g2, startPt, stopPt);
		}
	}*/
	private void drawBlkLine(Point startPt, Point stopPt) {
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(startPt.x, startPt.y, stopPt.x, stopPt.y);
		
	}
	
/*	public void drawBlkLine(Graphics2D g2, Point startPt, Point stopPt) {
	//	Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(startPt.x, startPt.y, stopPt.x, stopPt.y);
		drawPieceSingleton = this;
	}*/
	
	public static ArrayList<BlkLine> getBlkLines() {
		return blkLines;
	}

//	public DrawPiece drawPieceSingleton;
}


