package Graphic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Core.FinishPoint;

public class GraphicFinishPoint implements Drawable {
	private FinishPoint finishPoint;
	private JLabel img;
	
	public GraphicFinishPoint(FinishPoint fp){
		img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("field.jpg")));
		finishPoint = fp;
	}
	
	public JLabel getImage(){
		return img;
	}
	
	public void Draw(){
		int x = 800/finishPoint.getStorage().getHeight(); 
		int y = 800/finishPoint.getStorage().getWidth();
		img.setBounds(finishPoint.getY()*y, finishPoint.getX()*x, y, x);
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("field.jpg"));
		img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(y, x, Image.SCALE_SMOOTH)));
	}
}
