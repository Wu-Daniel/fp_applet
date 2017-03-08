package fp_applet;

import javax.swing.*;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;

public class FPApplet extends JApplet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		setSize(100,100);
		getContentPane().add(new FP_Main());
	}
}
