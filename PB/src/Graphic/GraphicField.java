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
	private BufferedImage image, honeyImage, oilImage;
	
	public GraphicField(Field f){
		field = f;
		URL resource = getClass().getClassLoader().getResource("field.jpg");
		URL resource2 = getClass().getClassLoader().getResource("honey.png");
		URL resource3 = getClass().getClassLoader().getResource("oil.png");
        try {
            image = ImageIO.read(resource);
            honeyImage = ImageIO.read(resource2);
            oilImage = ImageIO.read(resource3);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public BufferedImage getImage(){
		return image;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		
		int x = 800/field.getStorage().getHeight(); 
		int y = 800/field.getStorage().getWidth();
		g.drawImage(image, field.getY()*y, field.getX()*x, y, x, panel);
		if (field.GetFriction() == 3)
			g.drawImage(honeyImage, field.getY()*y, field.getX()*x, y, x, panel);
		if (field.GetFriction() == 1)
			g.drawImage(oilImage, field.getY()*y, field.getX()*x, y, x, panel);
		
	}
}
