package Graphic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.Box;

public class GraphicBox implements Drawable{
	private Box box;
	
	public GraphicBox(Box b){
		box = b;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		if (!box.isDisplayed())
			return;
		int x = 800/box.getStorage().getHeight(); 
		int y = 800/box.getStorage().getWidth();
		g.drawImage(Playing.boxImage, box.getY()*y, box.getX()*x, y, x, panel);
		
	}

}
