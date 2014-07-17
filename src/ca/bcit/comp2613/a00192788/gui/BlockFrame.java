package ca.bcit.comp2613.a00192788.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;

import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import ca.bcit.comp2613.quiltpad.QuiltPad;
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
	public static List<Block> blocks;
	private JButton btnNew;
	private JButton btnList;
	private JButton btnShow;
	private JButton btnDelete;
	private ButtonGroup buttonGroup;
	private JTextField nameTextField; 
	private JTextField sizeTextField;
	private JTextField uniquePiecesTextField;
	private JLabel lblName;
	private JLabel lblSize;
	private JLabel lblUPieces;
		
	
	public BlockFrame() {
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

	public void deleteBlock() {
		int response = JOptionPane.showConfirmDialog(null, "Do you really want "
							+ "to delete this block?", "Confirm",
		JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			// Delete specified block
			int row = blkTable.getSelectedRow();
			Integer id = (Integer) blkTable.getValueAt(row, 0);
		//	Block block = new Block(id, null, null, null);
		//	BlockUtil.delete(blocks, block);
			QuiltPad.blockRepository.delete(id);
			refreshTable();
		}
	}
	
	private void refreshTable() {
			
		Object[][] blkData = null;
		QuiltPad.blocks = QuiltPad.copyIterator(QuiltPad.blockRepository.findAll().iterator());
		blkData = new Object[QuiltPad.blocks.size()][4];
		int i = 0;
		for (Block block : QuiltPad.blocks) {
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
		frmBlocks.setLayout(new MigLayout("", "[][83.00][79.00][182.00][148.00]", "[][][][][][][][25][][25][][25]"));
			
		blkTable = new JTable(blkTableModel);
		scrollPane = new JScrollPane(blkTable);
		frmBlocks.add(scrollPane, "cell 1 0 7 6");
		
		buttonGroup = new ButtonGroup();
		
		btnNew = new JButton("New Block");
		buttonGroup.add(btnNew);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewBlockFrame();
			}
		});
		frmBlocks.add(btnNew, "cell 0 0, growx");
			
		btnList = new JButton("List Pieces");
		buttonGroup.add(btnList);	
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PieceFrame();
			}
		});
		frmBlocks.add(btnList, "cell 0 1");
			
		btnShow = new JButton("Show ");
		buttonGroup.add(btnShow);
		frmBlocks.add(btnShow, "cell 0 2, growx");
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBlock();
			}
		});
		frmBlocks.add(btnDelete, "cell 0 3, growx");
		
		lblName = new JLabel("Block Name");
		frmBlocks.add(lblName, "cell 1 7,alignx trailing");
		nameTextField = new JTextField();
		frmBlocks.add(nameTextField, "cell 2 7 2 1,growx");
		
		lblSize = new JLabel("Size");
		frmBlocks.add(lblSize, "cell 1 9,alignx trailing");
		sizeTextField = new JTextField();
		frmBlocks.add(sizeTextField, "cell 2 9,growx");
		
		lblUPieces = new JLabel("Unique Pieces");
		frmBlocks.add(lblUPieces, "cell 1 11,alignx trailing");
		uniquePiecesTextField = new JTextField();
		frmBlocks.add(uniquePiecesTextField, "cell 2 11,growx");
	}

}
