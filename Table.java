import javax.swing.table.AbstractTableModel;


public class Table extends AbstractTableModel{

	String[] col;
	int columns;
	int rows;
	public Table(int columns, int rows){
		this.columns = columns;
		this.rows = rows;
	}
	
	public Table(String[] col, int rows) {
		this.col = col;
		this.rows = rows;
	}

	private static final long serialVersionUID = -5597191617415549211L;

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
