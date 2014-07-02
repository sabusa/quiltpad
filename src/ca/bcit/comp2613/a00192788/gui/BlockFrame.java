package ca.bcit.comp2613.a00192788.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.a00192788.util.BlockUtil;
import ca.bcit.comp2613.quiltpad.model.Block;

import java.awt.FlowLayout;
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
	private JButton btnDelete;
	private ButtonGroup buttonGroup;
//	private JTextField idTextField;
//	private JTextField nameTextField;
//	private JTextField sizeTextField;
//	private JTextField uniquePiecesTextField;
	
	
	public BlockFrame() {
		blocks = BlockUtil.createBlocks();
		initialize();
		initTable();		
	}
		
	private void initTable() {

		blkTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*blkTable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							populateTable();
						}
					}
				});
		*/		
		refreshTable();
	}
		
	/*private void populateTable() {
		try {
			idTextField.setText(blkTable.getModel()
					.getValueAt(blkTable.getSelectedRow(), 0).toString());
			nameTextField.setText(blkTable.getModel()
					.getValueAt(blkTable.getSelectedRow(), 1).toString());
			sizeTextField.setText(blkTable.getModel()
					.getValueAt(blkTable.getSelectedRow(), 2).toString());
			uniquePiecesTextField.setText(blkTable.getModel()
					.getValueAt(blkTable.getSelectedRow(), 3).toString());
		} catch (Exception e) {}
	}*/

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
		frmBlocks.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5
				));

		blkTable = new JTable(blkTableModel);
		scrollPane = new JScrollPane(blkTable);
		frmBlocks.getContentPane().add(scrollPane);
			
		//btnNew = new JButton("New Block");
		
		btnList = new JButton("List Pieces");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listPieces();
			}
		});
		
		btnShow = new JButton("Show ");
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the log? ", "Log", JOptionPane.YES_NO_OPTION );
                 if (confirm == JOptionPane.YES_OPTION){ 
                	 deleteBlock();
                 }
			}
		});
		
		buttonGroup = new ButtonGroup();
		
		//buttonGroup.add(btnNew);
		buttonGroup.add(btnList);
		buttonGroup.add(btnShow);
		buttonGroup.add(btnDelete);	
		
		//frmBlocks.getContentPane().add(btnNew);
		frmBlocks.getContentPane().add(btnList);
		frmBlocks.getContentPane().add(btnShow);
		frmBlocks.getContentPane().add(btnDelete);
	}
}
