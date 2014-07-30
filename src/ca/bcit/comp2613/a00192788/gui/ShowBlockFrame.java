package ca.bcit.comp2613.a00192788.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ca.bcit.comp2613.quiltpad.model.Block;

@SuppressWarnings("serial")
public class ShowBlockFrame extends JFrame {
	private JFrame frmShowBlock;
	
	public ShowBlockFrame(Block block) {
		// create drawing frame for new block
		frmShowBlock = new JFrame();
		frmShowBlock.setPreferredSize(new Dimension(660, 660));
		frmShowBlock.setTitle("Block " + block.getName());
		frmShowBlock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmShowBlock.pack();
		frmShowBlock.setVisible(true);

		JPanel showPanel = new JPanel();
		Ruler ruler = new Ruler(block.getBlkSize(), block.getBlkLines());
		showPanel.add(ruler);

		frmShowBlock.getContentPane().add(showPanel);
	}
	
}

