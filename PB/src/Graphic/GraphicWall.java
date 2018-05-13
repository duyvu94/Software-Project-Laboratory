package Graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.Field;
import Core.Wall;

public class GraphicWall implements Drawable{
	private Wall wall;
	private BufferedImage image;
	
	public GraphicWall(Wall w){
		wall = w;
		URL resource = getClass().getClassLoader().getResource("wall.png");
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
		int x = 800/wall.getStorage().getHeight(); 
		int y = 800/wall.getStorage().getWidth();
		g.drawImage(image, wall.getY()*y, wall.getX()*x, y, x, panel);
		
	}
}
