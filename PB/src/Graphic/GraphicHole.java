package Graphic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Core.Hole;

public class GraphicHole implements Drawable{
	private Hole hole;
	private JLabel img;
	
	public GraphicHole(Hole h){
		img = new JLabel();
		hole = h;
	}
	
	public JLabel getImage(){
		return img;
	}
	
	public void Draw(){
		int x = 800/hole.getStorage().getHeight(); 
		int y = 800/hole.getStorage().getWidth();
		img.setBounds(hole.getY()*y, hole.getX()*x, y, x);
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("hole.jpg"));
		img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(y, x, Image.SCALE_SMOOTH)));
	}
}
