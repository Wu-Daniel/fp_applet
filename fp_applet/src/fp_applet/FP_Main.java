package fp_applet;

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
		
	JFrame frame = new JFrame(query);
	
	public FP_Main() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(200, 200);
		
		JPanel panel = new JPanel();
		
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					query = textField.getText();
				} catch (Exception e) {
					e.printStackTrace();
				}
				createMapPanel();
			}
		};
		
		
		b1.addActionListener(actionListener);
		
		panel.add(new JLabel("File Name"));
		panel.add(textField);
		panel.add(b1);
		
		frame.getContentPane().add(panel);
		frame.pack();
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	protected MapPanel createMapPanel() {
		MapPanel mapPanel = new MapPanel(query);
		return mapPanel;
	}
}