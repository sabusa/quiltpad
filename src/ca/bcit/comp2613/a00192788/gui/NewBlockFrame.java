package ca.bcit.comp2613.a00192788.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewBlockFrame extends JFrame {

	private final int MINSIZE = 3;
	private final int MAXSIZE = 16;
	private JFrame frmNewBlk;
	private JLabel lblBlkSize;
	private JTextField blkSizeField;

	public NewBlockFrame() {
		obtainBlkSize();
	}

	public void obtainBlkSize(){
		frmNewBlk = new JFrame();
		frmNewBlk.setTitle("Block Size");
		frmNewBlk.setSize(300,200);
		frmNewBlk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewBlk.setVisible(true);
		
		lblBlkSize = new JLabel("Enter the size of the block:");
		lblBlkSize.setBounds(75,75,25,25);
		 
		blkSizeField = new JTextField(15);
	    blkSizeField.setBounds(100,100,25,25);
	    blkSizeField.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) { 
	    		Integer blkSize;
	    		blkSize = getBlkSizeField();
	    		if ((blkSize < MINSIZE) || (blkSize > MAXSIZE)) {
	    		//	new Ruler(blkSize);
	    		}
	    		 		
            }
	    });	 
		JPanel panel = new JPanel();
	    panel.add(lblBlkSize);
	    panel.add(blkSizeField);
	     
	    frmNewBlk.add(panel);
  
        }

	 
	
	 public Integer getBlkSizeField() {   
		  return Integer.parseInt(blkSizeField.getText());
		  
	  }
}	  
