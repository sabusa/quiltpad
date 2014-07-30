package ca.bcit.comp2613.a00192788.gui;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import ca.bcit.comp2613.quiltpad.QuiltPad;
import ca.bcit.comp2613.quiltpad.model.BlkLine;
import ca.bcit.comp2613.quiltpad.model.Block;

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
//	private JButton btnUndo;
	private JButton btnSave;
	private ButtonGroup buttonGroup;
	private ArrayList<BlkLine> blkLines;

	/*
	 * NewBlockFrame Constructor
	 */
	public NewBlockFrame() {
		// read and verify user entered block size
		blkLines = new ArrayList<BlkLine>();
		blkSize = obtainBlkSize();
		drawNewDrawPanel(blkSize);
	}

	/*
	 * Read user input for block size and verify that it is a valid value
	 */
	public int obtainBlkSize() {
		// loop until valid block size is received
		do {
			size = JOptionPane.showInputDialog("Please enter "
					+ "the size of the block: ");
			blkSize = Integer.parseInt(size);
			if ((blkSize > MINSIZE - 1) && (blkSize < MAXSIZE + 1)) {
				validSize = true;
			} else {
				JOptionPane.showMessageDialog(null, "The block size must be a "
						+ "integer which is greater than 2 and smaller "
						+ "than 17", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while (validSize == false);
		return blkSize;
	}

	private void drawNewDrawPanel(final Integer blkSize) {
		// create drawing frame for new block
		frmNewBlock = new JFrame();
		frmNewBlock.setPreferredSize(new Dimension(750, 700));
		frmNewBlock.setTitle("New Block");
		frmNewBlock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNewBlock.pack();
		frmNewBlock.setVisible(true);

		controlPanel = new JPanel();
		controlPanel.setLayout(new MigLayout("", "[100][15][3][287][287][3]",
				"[][12.00][25][25][25][500][][]"));

		Ruler ruler = new Ruler(blkSize);
		controlPanel.add(ruler, "cell 2 0 4 6");

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
				controlPanel.repaint();
			}
		});
		controlPanel.add(btnReset, "cell 0 3,growx");

	/*	btnUndo = new JButton("Undo Last");
		buttonGroup.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blkLines = DrawPiece.getBlkLines();
				blkLines = DrawPiece.removeBlkLine(blkLines);
				ruler.repaint();
				ruler.add(new DrawBlock(blkLines));
				ruler.repaint();
				
					*/						

//				Graphics2D g2 = (Graphics2D) drawPiece.drawPieceSingleton
//						.getGraphics();
//
//				Thread myThread = new Thread() {
//
//					public void run() {
//						Graphics2D g2 = (Graphics2D) drawPiece.drawPieceSingleton
//								.getGraphics();
//						
//						drawPiece.redrawBlkLines(g2, blkLines);						
//					
//					}
//
//				};
//				myThread.start();
//
//				g2.setColor(Color.RED);
//
//			}
//	});
//		controlPanel.add(btnUndo, "cell 3 6,alignx left");

		btnSave = new JButton("Save");
		buttonGroup.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				String blkName = JOptionPane.showInputDialog("Please enter "
						+ "a name for the block: ");
				int id = blkLines.size() + 1;
				int uPieces = rand.nextInt(12) + 1;
				Block block = new Block(id, blkName, blkSize, uPieces, blkLines);
				QuiltPad.blockRepository.save(block);
				frmNewBlock.dispose();
				new BlockFrame();
				
			}
		});
		controlPanel.add(btnSave, "cell 4 6,alignx right");
		
		frmNewBlock.getContentPane().add(controlPanel);

	}
	
	/*
	 * check if the size of the block is a prime number
	 */
	/*
	 * private boolean isPrime(Integer blkSize) { boolean prime = true; // is
	 * block size equally divisible by another number for(int i = 2; i <
	 * blkSize; i++) { if(blkSize % i ==0) { prime = false; } } return prime; }
	 */

}

