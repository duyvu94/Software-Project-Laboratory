package Graphic;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Core.Wall;

public class GraphicWall implements Drawable{
	private Wall wall;
	private JLabel img;
	
	public GraphicWall(Wall w){
		wall = w;
		img = new JLabel();
	}
	
	public JLabel getImage(){
		return img;
	}
	
	public void Draw(){
		int x = 800/wall.getStorage().getHeight(); 
		int y = 800/wall.getStorage().getWidth();
		img.setBounds(wall.getY()*y, wall.getX()*x, y, x);
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("wall.png"));
		img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(y, x, Image.SCALE_SMOOTH)));
	}
}
