package fp_applet;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MapPanel extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String[]> regions = new ArrayList<String[]>();
	private String query;
	private String directory;
	
	private BufferedImage image;
	
	public static int xdim;
	public static int ydim;
	
	double mx;
	double my;	
		
	public MapPanel(String directory, String query) {
		this.directory = directory;
		this.query = query;
		
		mx = 0;
		my = 0;
		
		config(directory); 
		
		JFrame frame = new JFrame(query);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {        	
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
			image = ImageIO.read(new File(directory + "img\\" + query + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        JLabel picLabel = new JLabel(new ImageIcon(image));
                       
        frame.getContentPane().add(picLabel);
        frame.getContentPane().addMouseListener(this);
        frame.pack();
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
  	}
	
	public void config(String directory) {
		try {
			
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(directory + "config\\" + query + ".yaml"));
			
			String line;
			while ((line = br.readLine()) != null) {
				regions.add(line.split(","));
				//System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		// System.out.println(mx + " " + my);
		for (int i = 0; i < regions.size(); i++) {
			String[] temp = regions.get(i);
			if (mx > Integer.parseInt(temp[0]) && mx < Integer.parseInt(temp[1])) {
				if (my > Integer.parseInt(temp[2]) && my < Integer.parseInt(temp[3])) {
					new InventoryPanel(directory, temp[4]);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}		
	
}
	

