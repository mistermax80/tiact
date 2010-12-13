package time.model;

import javax.swing.table.AbstractTableModel;

public class TableTodayModel extends AbstractTableModel {

	private static final long serialVersionUID = -3844401442243862902L;
	String[] columnNames = { "Attività", "Dettaglio", "Orario" };
	Object[][] cells = {
				{ "Lavoro", "Inizio Giornata", "9:02" }, 
				{ "Lavoro", "Inizio Break", "10:35" },
				{ "Lavoro", "Fine Break", "10:45" },
				{ "Lavoro", "Inizio Pausa Pranzo", "13:05" },
				{ "Lavoro", "Fine Pausa Pranzo", "14:10" },
				{ "Lavoro", "Inizio Break", "16:00" },
				{ "Lavoro", "Fine Break", "16:10" },
				{ "Lavoro", "Fine Giornata", "18:07" }
	};

	public int getRowCount() {
		return cells.length;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int r, int c) {
		return cells[r][c];
	}

	public String getColumnName(int arg0) {
		return columnNames[arg0];
	}	
	
}
