package fp_applet;
import java.awt.BorderLayout;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
	
public class CSVTable extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTable table;
    DefaultTableModel model;

    
    /**
     * Takes data from a CSV file and places it into a table for display.
     * @param source - a reference to the file where the CSV data is located.
     */
    
    public CSVTable(String title, String source) {
    	super(title);
    	table = new JTable();
   		JScrollPane scroll = new JScrollPane(table);
   		String[] colNames = { "column1","column2"};
   		model = new DefaultTableModel(colNames, 0);
    	InputStream is;
    	try {
    		if(source.indexOf("http")==0) {
    			URL facultyURL = new URL(source);
    			is = facultyURL.openStream();
    		}
        else { //local file?
        	File f = new File(source);
            is = new FileInputStream(f);
        }
        insertData(is);
    	} catch(IOException ioe) {
    		JOptionPane.showMessageDialog(this, ioe, "Error reading data", JOptionPane.ERROR_MESSAGE);
    	}

    	getContentPane().add(scroll, BorderLayout.CENTER);
    	pack();
    }

/**
 * Places the data from the specified stream into this table for display.  The data from the file must be in CSV format
 * @param is - an input stream which could be from a file or a network connection or URL.
 */
    void insertData(InputStream is) {
    	Scanner scan = new Scanner(is);
    	String[] array;
    	while (scan.hasNextLine()) {
    		String line = scan.nextLine();
    		if(line.indexOf(",")>-1)
    			array = line.split(",");
    		else
    			array = line.split("\t");
    		Object[] data = new Object[array.length];
    		for (int i = 0; i < array.length; i++)
    			data[i] = array[i];

    		model.addRow(data);
    	}
    	table.setModel(model);
    }	 
}