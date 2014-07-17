package ca.bcit.comp2613.a00192788.gui;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class NewBlockFrame extends JFrame {
	
	private final int MINSIZE = 3;
	private final int MAXSIZE = 16;
	private JFrame frmNewBlock;
	private JPanel controlPanel;
	private Integer blkSize;
	private String size;
	private boolean validSize;
	private JButton btnNew;
	private JButton btnReset;
	private JButton btnUndo;
	private JButton btnSave;
	private ButtonGroup buttonGroup;
	
	/* 
	 * NewBlockFrame Constructor
	 */
	public NewBlockFrame() {
		// read and verify user entered block size
		blkSize = obtainBlkSize();
		drawNewDrawPanel(blkSize);
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
	
	private void drawNewDrawPanel(Integer blkSize2) {
		// create drawing frame for new block
		frmNewBlock = new JFrame();
		frmNewBlock.setPreferredSize(new Dimension(750, 700));
		frmNewBlock.setTitle("New Block");	
		frmNewBlock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frmNewBlock.pack();
		frmNewBlock.setVisible(true);	
				
		controlPanel = new JPanel();
		controlPanel.setLayout(new MigLayout("", "[100][15][5][287][287][3]", "[][12.00][25][25][25][500][][]"));
				
		buttonGroup = new ButtonGroup();
				
		btnNew = new JButton("Start New Block");
		buttonGroup.add(btnNew);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewBlock.dispose();
				new NewBlockFrame();
			}
		});
		controlPanel.add(btnNew, "cell 0 2");
				
		btnReset = new JButton("Reset Block");
		buttonGroup.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ruler ruler = new Ruler(blkSize);
				controlPanel.add(ruler, "cell 2 0 4 6");
				controlPanel.repaint();
				frmNewBlock.getContentPane().add(controlPanel);
			}
		});
		controlPanel.add(btnReset, "cell 0 3,growx");
								
		btnUndo = new JButton("Undo Last");
		buttonGroup.add(btnUndo);
		controlPanel.add(btnUndo, "cell 3 6,alignx left");
				
		btnSave = new JButton("Save");
		buttonGroup.add(btnSave);
		controlPanel.add(btnSave, "cell 4 6,alignx right");
				
		Ruler ruler = new Ruler(blkSize);
		controlPanel.add(ruler, "cell 2 0 4 6");
		frmNewBlock.getContentPane().add(controlPanel);
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
	
	

