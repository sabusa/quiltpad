package ca.bcit.comp2613.a00192788.gui;

import java.awt.*;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Rule extends JComponent {

    public int orientation;
    private final int PANELSIZE = 580;
    private final int OFFSET = 27;
    private final int SIZE = 35;    // space required for ticks and numbers
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1; 
    private int lineLength;
    private int position;
    private String num;
	private int gridSize;

    public Rule(int orientation, int gridSize) {
        this.orientation = orientation;
        this.gridSize = gridSize;
    }

    protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

	// set ruler background
	g2.setColor(new Color(230, 163, 4));
	g2.fillRect(0, 0, PANELSIZE, PANELSIZE);

	//set tick style
	g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
	g2.setColor(Color.black);

	// set rulers to show "inches"
    num = "inches";
	lineLength = 10;
	if (orientation == HORIZONTAL) {
	    g2.drawString(num, 2, 10);
	} else { // vertical
	    g2.drawString(num, 4, 10);
	}
	
	num = null;
	for (int i = 0; i < (2 * PANELSIZE/gridSize); i++) {
		// draw long ticks and number for full inches and short ticks for 1/2 inches
		if(i % 2 == 0) {   // full inch marking
			lineLength = 10;			
			num = Integer.toString(i/2);
		}
		else {				      // half inch marking
			lineLength = 7;
			num = null;
		}	
		
	   	// draw rulers
      	position = (i * gridSize/2) + OFFSET;	
	    if (orientation == HORIZONTAL) {
	        g2.drawLine(position, SIZE-1, position, SIZE-lineLength-1);
		    if (num != null)
	            g2.drawString(num, position-3, 21);
	    	} else { // vertical
	    		g2.drawLine(SIZE-1, position, SIZE-lineLength-1, position);
	    		if (num != null)
	            g2.drawString(num, 9, position+3);
	    	}
		}
    }
}
