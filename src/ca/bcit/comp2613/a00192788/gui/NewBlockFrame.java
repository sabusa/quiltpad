package ca.bcit.comp2613.a00192788.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewBlockFrame extends JFrame {

	private final int MINSIZE = 3;
	private final int MAXSIZE = 16;
	private JFrame frmNewBlock;
	private JLabel lblBlkSize;
	private Integer blkSize;
	private String size;
	private Boolean validSize = false;

	public NewBlockFrame() {
		obtainBlkSize();
	}

	public void obtainBlkSize(){
			
		do {
			size = JOptionPane.showInputDialog("Please enter "
					+ "the size of the block: ");
			blkSize = Integer.parseInt(size);
			if ((blkSize > MINSIZE) && (blkSize < MAXSIZE)) {
				validSize = true;
				frmNewBlock = new JFrame();
				frmNewBlock.setTitle("New Block");
				frmNewBlock.add(new Ruler(blkSize));
				frmNewBlock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				frmNewBlock.pack();
		        frmNewBlock.setVisible(true);				
			}
		}	
		while (!validSize);
	}	
	
}
	

