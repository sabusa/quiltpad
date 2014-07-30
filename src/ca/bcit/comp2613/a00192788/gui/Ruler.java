
package ca.bcit.comp2613.a00192788.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ca.bcit.comp2613.quiltpad.model.BlkLine;
import ca.bcit.comp2613.quiltpad.model.Block;

@SuppressWarnings("serial")
public class Ruler extends JPanel {

	private static final Integer GRIDMAX = 480;
	private final int PANELSIZE = 580;
	private Rule columnView;
	private Rule rowView;
    private JScrollPane ruler;
	private int gridSize;
	private Integer blkSize;
	private ArrayList<BlkLine> blkLines;
	

	public Ruler(Integer blkSize) {
		this.blkSize = blkSize;	
		gridSize = calcGrid(blkSize);
		blkLines = new ArrayList<BlkLine>();

		// create scroll pane
		ruler = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	   	ruler.setPreferredSize(new Dimension(PANELSIZE, PANELSIZE));
	   	ruler.setViewportView(new DrawPiece(gridSize, blkSize, blkLines));
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
		ruler.revalidate();
        add(ruler);
    }
	
	public Ruler(Integer blkSize, ArrayList<BlkLine> blkLines) {
		this.blkSize = blkSize;
		this.blkLines = blkLines;
		
		// create scroll pane
		gridSize = calcGrid(blkSize);
				
		ruler = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	   	ruler.setPreferredSize(new Dimension(PANELSIZE, PANELSIZE));
	   	ruler.setViewportView(new DrawPiece(gridSize, blkSize, blkLines));
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
		
		ruler.revalidate();
		// add to scroll pane
        add(ruler);
        
    }

	public Integer calcGrid(Integer blkSize) {
		gridSize = GRIDMAX / blkSize;
    	return gridSize;
	}

	public int getGridSize() {
		return gridSize;
	}

	  

}

