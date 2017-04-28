package fp_applet;

import javax.swing.*;

public class FPApplet extends JApplet {

	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame();
	
	@Override
	public void init() {
		setSize(100,100);
		//getContentPane().add(new FP_Main());
		getContentPane().add(new Menu(frame));
	}
}
