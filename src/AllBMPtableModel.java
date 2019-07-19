import java.awt.Font;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class AllBMPtableModel implements TableModel {
	
	int dimCount;
	Font internFont;
	
	@Override
	public int getRowCount() {
		return dimCount;
	}

	@Override
	public int getColumnCount() {
		return dimCount;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		/*
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			.substring(columnIndex, columnIndex+1);
		*/
		return "A";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		//return Integer.class;
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//return new Integer((rowIndex*dimCount)+columnIndex);
		StringBuilder sb = new StringBuilder();
		int codepoint = (rowIndex*dimCount)+columnIndex;
		//if (Character.isValidCodePoint(codepoint)) {
		if (internFont.canDisplay(codepoint)) {
            sb.append((char) codepoint);
		}
		return sb.toString();
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}
	
	public void setFont(Font passedFont){
		internFont = passedFont;
	}
	
	//Constructors
	public AllBMPtableModel() {
		dimCount = 10;
	}
	
	public AllBMPtableModel(int passedCount, Font passedFont) {
		dimCount = passedCount;
		setFont(passedFont);
	}
	
}
