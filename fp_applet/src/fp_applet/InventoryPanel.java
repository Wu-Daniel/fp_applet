package fp_applet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

import java.awt.Image;

public class InventoryPanel {

	public static String query;
	
    JTable table;
    DefaultTableModel model;
    JButton closeButton, webButton;
    
	public InventoryPanel(String query) {
		InventoryPanel.query = query;
		
		String loc = "C:\\Users\\ddand_000\\git\\fp_applet\\fp_applet\\dat\\" + query;
		CSVTable frame = new CSVTable(query,loc);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		
}
