package ca.bcit.comp2613.a00192788.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NewBlockFrame extends JFrame {

	private final int MINSIZE = 3;
	private final int MAXSIZE = 16;
	private JFrame frmNewBlock;
	private Integer blkSize;
	private String size;
	private boolean validSize;
	
	/* 
	 * NewBlockFrame Constructor
	 */
	public NewBlockFrame() {
		obtainBlkSize();
	}

	/* 
	 * Read user input for block size and verify that it is a valid value
	 */
	public void obtainBlkSize(){
		// loop until valid block size is received			
		do {
			size = JOptionPane.showInputDialog("Please enter "
						+ "the size of the block: ");
			blkSize = Integer.parseInt(size);
			if ((blkSize > MINSIZE) && (blkSize < MAXSIZE) && 
						(isPrime(blkSize) == false)) {
				validSize = true;
				// create drawing frame for new block
				frmNewBlock = new JFrame();
				frmNewBlock.setTitle("New Block");
				frmNewBlock.add(new Ruler(blkSize));
				frmNewBlock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				frmNewBlock.pack();
		        frmNewBlock.setVisible(true);				
			}
			else { 
				JOptionPane.showMessageDialog(null, "The block size must be a "
						+ "non-prime integer which is greater than 2 and smaller "
						+ "than 17", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}	
		while (validSize == false);
	}
	/*
	 * check if the size of the block is a prime number
	 */
	private boolean isPrime(Integer blkSize) {
		boolean prime = true;
		// is block size equally divisible by another number
		for(int i = 2; i < blkSize; i++) {
			if(blkSize % i ==0) {
		    	prime =  false;
			}
		}
		return prime;
	}
	
}
	
	

