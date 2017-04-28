package fp_applet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class InventoryPanel {

	public static String query;
	
    JTable table;
    DefaultTableModel model;
    JButton closeButton, webButton;
    
	public InventoryPanel(String directory, String query) {
		InventoryPanel.query = query;
		
		String loc = directory + "dat\\" + query;
		CSVTable frame = new CSVTable(query,loc);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
