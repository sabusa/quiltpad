package ca.bcit.comp2613.a00192788.gui;
	
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.a00192788.util.BlockUtil;
import ca.bcit.comp2613.a00192788.util.PieceUtil;
import ca.bcit.comp2613.quiltpad.model.Block;
import ca.bcit.comp2613.quiltpad.model.Piece;

import java.awt.FlowLayout;


@SuppressWarnings("serial")
public class PieceFrame extends JFrame {
	
	private final int WIDTH = 600;
	private final int HEIGHT = 525;
	private JFrame frmPieces;
	private JScrollPane scrollPane;
	private JTable pTable;
	private NonEditableDefaultTableModel pTableModel;
	public String[] columnNames = new String[] { "Id", "Type", "Value", "Quantity" };
	public static ArrayList<Piece> pieces;
	private ArrayList<Piece> blkPieces;
	//private JButton btnNew;
	//private JButton btnList;
	//private JButton btnShow;
	//private ButtonGroup buttonGroup;
	private JTextField idTextField;
	private JTextField typeTextField;
	private JTextField valueTextField;
	private JTextField pQtyTextField;
		
		
	/*public PieceFrame(String name) {
		blkPieces = PieceUtil.findPieces(pieces, name);
		initialize();
		initTable();		
	}*/
			
	public PieceFrame() {
		blkPieces = PieceUtil.createPieces();
		initialize();
		initTable();		
	}
	private void initTable() {

		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.getSelectionModel().addListSelectionListener(
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
			idTextField.setText(pTable.getModel()
				.getValueAt(pTable.getSelectedRow(), 0).toString());
			typeTextField.setText(pTable.getModel()
				.getValueAt(pTable.getSelectedRow(), 1).toString());
			valueTextField.setText(pTable.getModel()
				.getValueAt(pTable.getSelectedRow(), 2).toString());
			pQtyTextField.setText(pTable.getModel()
				.getValueAt(pTable.getSelectedRow(), 3).toString());
		} catch (Exception e) {}
	}

	private void refreshTable() {
		
		Object[][] pData = null;
		pData = new Object[blkPieces.size()][4];

		int i = 0;
		for (Piece piece : blkPieces) {
			pData[i][0] = piece.getId();
			pData[i][1] = piece.getsType();
			pData[i][2] = piece.getfValue();
			pData[i][3] = piece.getpQty();
			i++;
		}
		pTableModel.setDataVector(pData, columnNames);
		pTable.repaint();
	}
			
	/**
	 * Initialize the frame components and draw frame
	 **/
	private void initialize() {
		frmPieces = new JFrame();
		frmPieces.setTitle("Pieces");
		frmPieces.setBounds(100, 100, WIDTH, HEIGHT);
		frmPieces.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPieces.setVisible(true);
				
		pTableModel = new NonEditableDefaultTableModel();
		frmPieces.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		pTable = new JTable(pTableModel);
		scrollPane = new JScrollPane(pTable);
		frmPieces.getContentPane().add(scrollPane);
				
		//btnNew = new JButton("New Block");
		//btnList = new JButton("List Pieces");
		//btnShow = new JButton("Show ");
		//buttonGroup = new ButtonGroup();
		//buttonGroup.add(btnNew);
		//buttonGroup.add(btnList);
		//buttonGroup.add(btnShow);
				
		//frmPieces.getContentPane().add(btnNew);
		//frmPieces.getContentPane().add(btnList);
		//frmPieces.getContentPane().add(btnShow);
	}
	
}



