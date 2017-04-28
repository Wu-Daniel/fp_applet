package fp_applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame("Search");
	private String directory;
	private String query;
	
	private JTextField textField = new JTextField(5);
	private JButton b1 = new JButton("Local");
	private JButton b2 = new JButton("Sql");
	
	public SearchPanel(String directory) {
		this.directory = directory;
		
		JPanel panel = new JPanel();
		
		ActionListener actionListener1 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				query = textField.getText();
				new LocalSearch(query, directory);
			}
		};
		
		ActionListener actionListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				query = textField.getText();
			}
		};
		
		
		b1.addActionListener(actionListener1);
		b2.addActionListener(actionListener2);
		panel.add(textField);
		panel.add(b1);
		panel.add(b2);
		
		frame.getContentPane().add(panel);
		frame.pack();
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
