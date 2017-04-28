package fp_applet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JButton b1 = new JButton("Region Search");
	private JButton b2 = new JButton("Lookup Query ");
	private JButton b3 = new JButton("Set Directory");
	
	private String directory = "C:\\Users\\ddand_000\\git\\fp_applet\\fp_applet\\";
	private DebugPanel debug;
	
	public Menu(JFrame frame) {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (debug != null) {
					if (debug.getDirectory() != null){
						directory = debug.getDirectory();
					}
				}
				frame.getContentPane().add(new FP_Main(directory));
			}
		};
		
		ActionListener actionListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().add(new SearchPanel(directory));
			}
		};
		
		ActionListener actionListener3 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				debug = new DebugPanel();
				frame.getContentPane().add(debug);				
			}
		};
		
		b1.addActionListener(actionListener);
		b2.addActionListener(actionListener2);
		b3.addActionListener(actionListener3);
		
		add(b1);
		add(b2);
		add(b3);
	}
	
	
	protected void createQueryPanel() {
		
	}
}