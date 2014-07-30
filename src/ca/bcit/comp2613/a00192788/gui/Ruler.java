
package ca.bcit.comp2613.a00192788.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ca.bcit.comp2613.quiltpad.model.BlkLine;

@SuppressWarnings("serial")
public class Ruler extends JPanel {

	private static final Integer GRIDMAX = 480;
	private final int PANELSIZE = 580;
	private Rule columnView;
	private Rule rowView;
    private JScrollPane ruler;
	private static int gridSize;
	private ArrayList<BlkLine> blkLines;
	

	public Ruler(Integer blkSize) {
		
		// create scroll pane
		gridSize = calcGrid(blkSize);
		blkLines = new ArrayList<BlkLine>();
		ruler = new JScrollPane(new DrawPiece(gridSize, blkSize, blkLines), 
								JScrollPane.VERTICAL_SCROLLBAR_NEVER,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	   	ruler.setPreferredSize(new Dimension(PANELSIZE, PANELSIZE));
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
     //   setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}

	public static Integer calcGrid(Integer blkSize) {
		gridSize = GRIDMAX / blkSize;
    	return gridSize;
	}

	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		Ruler.gridSize = gridSize;
	}
		  

}

