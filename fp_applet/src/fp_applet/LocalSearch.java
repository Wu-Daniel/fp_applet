package fp_applet;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.*;

public class LocalSearch extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame("Result");
	
	private ArrayList<String> matches;
	
	public LocalSearch(String query, String directory) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		String loc = directory + "dat\\";
		File dir = new File(loc);
		File[] matches = dir.listFiles(new FilenameFilter()
		{
		  public boolean accept(File dir, String name)
		  {
		     return name.endsWith("csv");
		  }
		});
		
		for(File file : matches) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(loc + file.getName()));
				String line;
				while ((line = br.readLine()) != null) {
					String[] split = line.split(",");
					if (split[1].equalsIgnoreCase(query)) {
						System.out.println(line);
						panel.add(new JLabel(file.getName() + " , " + split[0]));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		frame.getContentPane().add(panel);
		frame.pack();
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
