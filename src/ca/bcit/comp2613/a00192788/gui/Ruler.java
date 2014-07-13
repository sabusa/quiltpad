package ca.bcit.comp2613.a00192788.gui;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Ruler extends JPanel {

	private final int PANESIZE = 580;
	private Rule columnView;
	private Rule rowView;
    private JScrollPane ruler;
	private int gridSize;
	

	public Ruler(Integer blkSize) {
		
		// create scroll pane
		gridSize = DrawPanel.calcGrid(blkSize);
		ruler = new JScrollPane(new Grid(gridSize));
	   	ruler.setPreferredSize(new Dimension(PANESIZE, PANESIZE));
		ruler.setViewportBorder(BorderFactory.createLineBorder(Color.black));

		// add horizontal ruler
		columnView = new Rule(Rule.HORIZONTAL, gridSize);
		columnView.setPreferredSize(new Dimension(0,40));
		ruler.setColumnHeaderView(columnView);

		//add vertical ruler
		rowView = new Rule(Rule.VERTICAL, gridSize);
		rowView.setPreferredSize(new Dimension(40,0));
		ruler.setRowHeaderView(rowView);
		
		// extend ruler into upper left corner
		JPanel corner = new JPanel();
		corner.setBackground(new Color(230, 163, 4));
		ruler.setCorner(JScrollPane.UPPER_LEFT_CORNER, corner);
		
		// add to scroll pane
        add(ruler);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}
	  
}

