package ca.bcit.comp2613.a00192788.gui;
	
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.a00192788.util.PieceUtil;
import ca.bcit.comp2613.quiltpad.model.Piece;


@SuppressWarnings("serial")
public class PieceFrame extends JFrame {
	
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private JFrame frmPieces;
	private JScrollPane scrollPane;
	private JTable pTable;
	private NonEditableDefaultTableModel pTableModel;
	public String[] columnNames = new String[] { "Id", "Type", "Value", "Quantity" };
	public static ArrayList<Piece> pieces;
	private ArrayList<Piece> blkPieces;
	private JTextField typeTextField;
	private JTextField valueTextField;
	private JTextField pQtyTextField;
	private JLabel lblType;
	private JLabel lblValue; 
	private JLabel lblpQty;
		
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
		frmPieces.setLayout(null);

		pTable = new JTable(pTableModel);
		scrollPane = new JScrollPane(pTable);
		scrollPane.setBounds(45,20,500,390);
		frmPieces.add(scrollPane);
				
		lblType = new JLabel("Type");
		lblType.setBounds(100,430,100,25);
		frmPieces.add(lblType);
		typeTextField = new JTextField();
		typeTextField.setBounds(165,430,150,25);
		typeTextField.setColumns(20);
		frmPieces.add(typeTextField);
		
		lblValue = new JLabel("Value");
		lblValue.setBounds(100,470,100,25);
		frmPieces.add(lblValue);
		valueTextField = new JTextField();
		valueTextField.setBounds(165,470,150,25);
		valueTextField.setColumns(15);
		frmPieces.add(valueTextField);
		
		lblpQty = new JLabel("Quantity");
		lblpQty.setBounds(100,510,120,25);
		frmPieces.add(lblpQty);
		pQtyTextField = new JTextField();
		pQtyTextField.setBounds(165,510,80,25);
		pQtyTextField.setColumns(7);
		frmPieces.add(pQtyTextField);
	}
	
}



