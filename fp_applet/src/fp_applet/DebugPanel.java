package fp_applet;

import java.awt.event.*;
import javax.swing.*;

public class DebugPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String directory;
	private JTextField textField = new JTextField(5);
	private JButton b1 = new JButton("OK");
	private JFrame frame = new JFrame();
	
	public DebugPanel() {
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				directory = textField.getText();
			}
		};
		
		
		b1.addActionListener(actionListener);
		
		panel.add(new JLabel("Set Directory"));
		panel.add(textField);
		panel.add(b1);
		
		frame.getContentPane().add(panel);
		frame.pack();
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	public String getDirectory() {
		return directory;
	}
}