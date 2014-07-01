package ca.bcit.comp2613.a00192788.gui;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NonEditableDefaultTableModel extends DefaultTableModel {
	
	 @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	
}
