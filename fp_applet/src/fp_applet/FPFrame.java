package fp_applet;

import javax.swing.*;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;

public class FPFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public FPFrame() {
		init();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
	        @Override
	        public void run() {
	            new FPFrame();
	        }
	    });
	}
	
	public void init() {
		setSize(100,100);
		Menu menu = new Menu(this);
		getContentPane().add(menu);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
