package fp_applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JButton b1 = new JButton("Region Search");
	private JButton b2 = new JButton("Lookup Query");
	
	public Menu(JFrame frame) {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().add(createSearchPanel());
			}
		};
		
		ActionListener actionListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		
		
		b1.addActionListener(actionListener);
		b2.addActionListener(actionListener2);

		add(b1);
		add(b2);
	}
	
	protected JPanel createSearchPanel() {
		FP_Main fpmain = new FP_Main();
		return fpmain;
	}
	
	protected void createQueryPanel() {
		
	}
}