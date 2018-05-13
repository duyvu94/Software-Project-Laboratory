package Graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.Field;

public class GraphicField implements Drawable{
	private Field field;
	
	public GraphicField(Field f){
		field = f;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		
		int x = 800/field.getStorage().getHeight(); 
		int y = 800/field.getStorage().getWidth();
		g.drawImage(Playing.fieldImage, field.getY()*y, field.getX()*x, y, x, panel);
		if (field.GetFriction() == 3)
			g.drawImage(Playing.honeyImage, field.getY()*y, field.getX()*x, y, x, panel);
		if (field.GetFriction() == 1)
			g.drawImage(Playing.oilImage, field.getY()*y, field.getX()*x, y, x, panel);
		
	}
}
