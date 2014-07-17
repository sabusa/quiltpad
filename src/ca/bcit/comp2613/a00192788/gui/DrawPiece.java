package ca.bcit.comp2613.a00192788.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import ca.bcit.comp2613.quiltpad.model.BlkLine;


@SuppressWarnings("serial")
public class DrawPiece extends JPanel{

	private final int PANESIZE = 520;	
	private Point startPt, stopPt;
	private static ArrayList<BlkLine> blkLines = new ArrayList<BlkLine>();
	private static DrawPanel drawPanel;
	
	public DrawPiece() {
		drawPanel = new DrawPanel();
		setPreferredSize(new Dimension(PANESIZE, PANESIZE));
		// add grid
		add(drawPanel);
		

		addMouseListener(new MouseListener() {     	  
			public void mousePressed(MouseEvent e) {
				// go to closest node from mouse pressed to start line
				startPt = drawPanel.goToClosestNode(e.getPoint());
				drawPanel.circleNode(startPt);
			//	repaint();
  			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// go to closest node from mouse pressed to start line
				stopPt = drawPanel.goToClosestNode(e.getPoint());
				drawPanel.circleNode(stopPt);
				drawPanel.drawBlkLine(startPt, stopPt);
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
	
	public ArrayList<BlkLine> addBlkLine(ArrayList<BlkLine> blkLines, Point startPt, Point stopPt) {
		ArrayList<BlkLine> retval = blkLines;
		blkLines.add(new BlkLine(startPt, stopPt));
		return retval;
	}
	
	public ArrayList<BlkLine> removeBlkLine(ArrayList<BlkLine> blkLines) {
		ArrayList<BlkLine> retval = blkLines;
		blkLines.remove(blkLines.size() - 1);
		return retval;
	}
	
	public void redrawBlkLines(ArrayList<BlkLine> blkLines) {
		for (int i=0; i<blkLines.size(); i++) {
			Point startPt = blkLines.get(i).getStartPt();
			Point stopPt = blkLines.get(i).getStopPt();
			drawPanel.drawBlkLine(startPt, stopPt);
			drawPanel.repaint();
			}
	}
	
 
}


