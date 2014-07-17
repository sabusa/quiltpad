package ca.bcit.comp2613.a00192788.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Component;

@SuppressWarnings("serial")
public class NewBlockFrame extends JFrame {
	
	private final int MINSIZE = 3;
	private final int MAXSIZE = 16;
	private JFrame frmNewBlock;
	private JPanel controlPanel;
	private Integer blkSize;
	private String size;
	private boolean validSize;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	/* 
	 * NewBlockFrame Constructor
	 */
	public NewBlockFrame() {
		blkSize = obtainBlkSize();
		// create drawing frame for new block
		frmNewBlock = new JFrame();
		frmNewBlock.setPreferredSize(new Dimension(750, 700));
		frmNewBlock.setTitle("New Block");
		controlPanel = new JPanel();
		controlPanel.setLayout(new MigLayout("", "[100][20][3][287][287][3]", "[][12.00][25][25][25][500][][]"));
		
		frmNewBlock.getContentPane().add(controlPanel);
		
		Ruler ruler = new Ruler(blkSize);
		controlPanel.add(ruler, "cell 2 0 4 6");
		
		btnNewButton_1 = new JButton("New button");
		controlPanel.add(btnNewButton_1, "cell 0 2");
		
		btnNewButton_2 = new JButton("New button");
		controlPanel.add(btnNewButton_2, "cell 0 3");
		
		btnNewButton = new JButton("New button");
		controlPanel.add(btnNewButton, "cell 0 4");
		
		btnNewButton_4 = new JButton("New button");
		controlPanel.add(btnNewButton_4, "cell 3 6,alignx left");
		
		btnNewButton_3 = new JButton("New button");
		controlPanel.add(btnNewButton_3, "cell 4 6,alignx right");
		frmNewBlock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frmNewBlock.pack();
        frmNewBlock.setVisible(true);	
   	}

	/* 
	 * Read user input for block size and verify that it is a valid value
	 */
	public int obtainBlkSize(){
		// loop until valid block size is received			
		do {
			size = JOptionPane.showInputDialog("Please enter "
						+ "the size of the block: ");
			blkSize = Integer.parseInt(size);
			if ((blkSize > MINSIZE-1) && (blkSize < MAXSIZE+1)) {
				validSize = true;
			}
			else { 
				JOptionPane.showMessageDialog(null, "The block size must be a "
						+ "integer which is greater than 2 and smaller "
						+ "than 17", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}	
		while (validSize == false);
		return blkSize;
	}
	/*
	 * check if the size of the block is a prime number
	 */
	/*private boolean isPrime(Integer blkSize) {
		boolean prime = true;
		// is block size equally divisible by another number
		for(int i = 2; i < blkSize; i++) {
			if(blkSize % i ==0) {
		    	prime =  false;
			}
		}
		return prime;
	}
	*/
	
	
	
}
	
	

