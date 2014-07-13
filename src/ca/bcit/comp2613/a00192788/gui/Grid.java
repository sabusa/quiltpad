package ca.bcit.comp2613.a00192788.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Grid extends JPanel{

	private final int PANESIZE = 520;	
	private Point startP, stopP;
	
	public Grid(int gridSize) {
		final DrawPanel drawPanel = new DrawPanel();	
				
		setPreferredSize(new Dimension(PANESIZE, PANESIZE));
		// add grid
		add(drawPanel);

		addMouseListener(new MouseListener() {     	  
			public void mousePressed(MouseEvent e) {
				// go to closest node from mouse pressed to start line
				startP = drawPanel.goToClosestNode(e.getPoint());
				drawPanel.circleNode(startP);
			//	repaint();
  			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// go to closest node from mouse pressed to start line
				stopP = drawPanel.goToClosestNode(e.getPoint());
				drawPanel.circleNode(stopP);
				drawPanel.drawPiece(startP, stopP);
		
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
	
 
}


