package ca.bcit.comp2613.a00192788.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import ca.bcit.comp2613.a00192788.util.BlockUtil;
import ca.bcit.comp2613.quiltpad.model.Block;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class BlockFrame extends JFrame {
	
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private JFrame frmBlocks;
	private JScrollPane scrollPane;
	private JTable blkTable;
	private NonEditableDefaultTableModel blkTableModel;
	public String[] columnNames = new String[] { "Id", "Name", "Size", "Unique Pieces" };
	public static ArrayList<Block> blocks;
	private JButton btnNew;
	private JButton btnList;
	private JButton btnShow;
	private ButtonGroup buttonGroup;
	private JTextField nameTextField; 
	private JTextField sizeTextField;
	private JTextField uniquePiecesTextField;
	private JLabel lblName;
	private JLabel lblSize;
	private JLabel lblUPieces;
	private JButton button;

	
	
	public BlockFrame() {
		blocks = BlockUtil.createBlocks();
		initialize();
		initTable();		
	}
		
	private void initTable() {

		blkTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		blkTable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							populateTable();
						}
					}
				});		
		refreshTable();
	}
		
	private void populateTable() {
		try {
			nameTextField.setText(blkTable.getModel()
					.getValueAt(blkTable.getSelectedRow(), 1).toString());
			sizeTextField.setText(blkTable.getModel()
					.getValueAt(blkTable.getSelectedRow(), 2).toString());
			uniquePiecesTextField.setText(blkTable.getModel()
					.getValueAt(blkTable.getSelectedRow(), 3).toString());
		} catch (Exception e) {}
	}

	public void listPieces() {
		//String id = idTextField.getText();
		//new PieceFrame(name);
		new PieceFrame();
	}
	
	public void deleteBlock() {
		
		int row = blkTable.getSelectedRow();
		Integer id = (Integer) blkTable.getValueAt(row, 0);
		System.out.println(id);
		Block block = new Block(id, null, null, null);
		BlockUtil.delete(blocks, block);
		refreshTable();
	}
	
	private void refreshTable() {
			
		Object[][] blkData = null;
		blkData = new Object[blocks.size()][4];
		int i = 0;
		for (Block block : blocks) {
			blkData[i][0] = block.getId();
			blkData[i][1] = block.getName();
			blkData[i][2] = block.getBlkSize();
			blkData[i][3] = block.getUniquePieces();
			i++;
		}
		blkTableModel.setDataVector(blkData, columnNames);
		blkTable.repaint();
	}
		
	/**
	 * Initialize the frame components and draw frame
	 **/
	private void initialize() {
		frmBlocks = new JFrame();
		frmBlocks.setTitle("Blocks");
		frmBlocks.setBounds(100, 100, WIDTH, HEIGHT);
		frmBlocks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlocks.setVisible(true);
			
		blkTableModel = new NonEditableDefaultTableModel();
		frmBlocks.getContentPane().setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][]"));
			
		blkTable = new JTable(blkTableModel);
		scrollPane = new JScrollPane(blkTable);
		frmBlocks.getContentPane().add(scrollPane, "cell 1 0 6 6");
		
		buttonGroup = new ButtonGroup();
		
		btnNew = new JButton("New Block");
		buttonGroup.add(btnNew);
		frmBlocks.getContentPane().add(btnNew, "cell 0 0, growx");
			
		btnList = new JButton("List Pieces");
		buttonGroup.add(btnList);	
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listPieces();
			}
		});
		frmBlocks.getContentPane().add(btnList, "cell 0 1");
			
		btnShow = new JButton("Show ");
		buttonGroup.add(btnShow);
		frmBlocks.getContentPane().add(btnShow, "cell 0 2, growx");
		
		button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmBlocks.getContentPane().add(button, "cell 0 3, growx");
		
		lblName = new JLabel("Block Name");
		frmBlocks.getContentPane().add(lblName, "cell 0 7,alignx trailing");
		nameTextField = new JTextField();
		frmBlocks.getContentPane().add(nameTextField, "cell 1 7,growx");
		
		lblSize = new JLabel("Size");
		frmBlocks.getContentPane().add(lblSize, "cell 0 9,alignx trailing");
		sizeTextField = new JTextField();
		frmBlocks.getContentPane().add(sizeTextField, "cell 1 9,growx");
		
		lblUPieces = new JLabel("Unique Pieces");
		frmBlocks.getContentPane().add(lblUPieces, "cell 0 11,alignx trailing");
		uniquePiecesTextField = new JTextField();
		frmBlocks.getContentPane().add(uniquePiecesTextField, "cell 1 11,growx");
	}

}
