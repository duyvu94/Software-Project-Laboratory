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
	
	public GraphicHole(Hole h){
		hole = h;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		int x = 800/hole.getStorage().getHeight(); 
		int y = 800/hole.getStorage().getWidth();
		g.drawImage(Playing.fieldImage, hole.getY()*y, hole.getX()*x, y, x, panel);
		if (hole.isOpened())
			g.drawImage(Playing.holeImage, hole.getY()*y, hole.getX()*x, y, x, panel);
		else
			g.drawImage(Playing.closedHoleImage, hole.getY()*y, hole.getX()*x, y, x, panel);
	}
}
