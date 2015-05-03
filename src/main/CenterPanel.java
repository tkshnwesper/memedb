package main;

import javax.swing.JTable;


public class CenterPanel {
	JTable memeTable;
	String[] columnNames = { "Title",
			"Description",
			"Tags",
			"Category"
		};
	Object[][] tableData;
	db mdb = new db();
	
	void populateData() {
		
	}
	
	CenterPanel() {
		memeTable = new JTable(tableData, columnNames);
	}

}
