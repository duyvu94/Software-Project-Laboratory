package Graphic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Core.Switch;

public class GraphicSwitch implements Drawable{
	private Switch sw;
	private JLabel img;
	
	public GraphicSwitch(Switch s){
		img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("field.jpg")));
		sw = s;
	}
	
	public JLabel getImage(){
		return img;
	}
	
	public void Draw(){
		int x = 800/sw.getStorage().getHeight(); 
		int y = 800/sw.getStorage().getWidth();
		img.setBounds(sw.getY()*y, sw.getX()*x, y, x);
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("switch.png"));
		img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(y, x, Image.SCALE_SMOOTH)));
	}
}
