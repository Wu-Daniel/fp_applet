package fp_applet;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class FP_Main extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String query;
	private JTextField textField = new JTextField(5);
	private JButton b1 = new JButton("Search");
	private JLabel status = new JLabel("     File Name");	
	JFrame frame = new JFrame(query);
		
	public FP_Main(String directory) {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 200);
		
		JPanel panel = new JPanel();
		
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				query = textField.getText();
				try {
					new MapPanel(directory,query);
				} catch (Exception e) {
					//e.printStackTrace();
					status.setText("File Not Found");
					status.setForeground(Color.RED);
				}
			}
		};
		
		
		b1.addActionListener(actionListener);
		

		panel.add(textField);
		panel.add(status);
		panel.add(b1);
		
		frame.getContentPane().add(panel);
		frame.pack();
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
}