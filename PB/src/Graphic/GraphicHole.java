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

import Core.Hole;

public class GraphicHole implements Drawable{
	private Hole hole;
	private BufferedImage image, backgroundImage, closedHoleImage;
	
	public GraphicHole(Hole h){
		hole = h;
		URL resource = getClass().getClassLoader().getResource("hole.png");
		URL resource1 = getClass().getClassLoader().getResource("field.jpg");
		URL resource2 = getClass().getClassLoader().getResource("closedhole.png");
        try {
            image = ImageIO.read(resource);
            backgroundImage = ImageIO.read(resource1);
            closedHoleImage = ImageIO.read(resource2);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public BufferedImage getImage(){
		return image;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		int x = 800/hole.getStorage().getHeight(); 
		int y = 800/hole.getStorage().getWidth();
		g.drawImage(backgroundImage, hole.getY()*y, hole.getX()*x, y, x, panel);
		if (hole.isOpened())
			g.drawImage(image, hole.getY()*y, hole.getX()*x, y, x, panel);
		else
			g.drawImage(closedHoleImage, hole.getY()*y, hole.getX()*x, y, x, panel);
	}
}
