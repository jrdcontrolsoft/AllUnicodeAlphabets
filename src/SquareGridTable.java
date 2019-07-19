import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


public class SquareGridTable extends JTable {

	public SquareGridTable() {
		// TODO Auto-generated constructor stub
	}

	public SquareGridTable(TableModel dm) {
		super(dm);
		// TODO Auto-generated constructor stub
	}

	public SquareGridTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		// TODO Auto-generated constructor stub
	}

	public SquareGridTable(TableModel dm, int dim, Font uniFont) {
		super(dm);
		setGridColor(Color.GRAY);
		setEnabled(false);
        TableColumn currCol = null;
        for (int i = 0; i < getColumnCount(); i++) {
        	currCol = getColumnModel().getColumn(i);
        	currCol.setMinWidth(dim);
        	currCol.setMaxWidth(dim);
        }
        setRowHeight(dim);
        setTableHeader(null);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setFont(uniFont);
	}

	public SquareGridTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		// TODO Auto-generated constructor stub
	}

	public SquareGridTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public SquareGridTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public SquareGridTable(TableModel dm, TableColumnModel cm,
			ListSelectionModel sm) {
		super(dm, cm, sm);
		// TODO Auto-generated constructor stub
	}

}
