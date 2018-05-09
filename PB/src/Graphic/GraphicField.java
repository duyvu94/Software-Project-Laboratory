package Graphic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Core.Field;

public class GraphicField implements Drawable{
	private Field field;
	private JLabel img;
	
	public GraphicField(Field f){
		img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("field.jpg")));
		field = f;
	}

	public JLabel getImage(){
		return img;
	}
	
	public void Draw(){
		int x = 800/field.getStorage().getHeight(); 
		int y = 800/field.getStorage().getWidth();
		img.setBounds(field.getY()*y, field.getX()*x, y, x);
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("field.jpg"));
		img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(y, x, Image.SCALE_FAST)));
	}

}
