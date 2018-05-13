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
	private BufferedImage image;
	
	public GraphicBox(Box b){
		box = b;
		URL resource = getClass().getClassLoader().getResource("box.png");
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public BufferedImage getImage(){
		return image;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		if (!box.isDisplayed())
			return;
		int x = 800/box.getStorage().getHeight(); 
		int y = 800/box.getStorage().getWidth();
		g.drawImage(image, box.getY()*y, box.getX()*x, y, x, panel);
		
	}

}
