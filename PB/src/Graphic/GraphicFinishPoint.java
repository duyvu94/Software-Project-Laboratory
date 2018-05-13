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

import Core.FinishPoint;

public class GraphicFinishPoint implements Drawable {
	private FinishPoint finishPoint;
	
	public GraphicFinishPoint(FinishPoint fp){
		finishPoint = fp;

	}
	
	public void Draw(Graphics g, JPanel panel) {
		int x = 800/finishPoint.getStorage().getHeight(); 
		int y = 800/finishPoint.getStorage().getWidth();
		g.drawImage(Playing.fieldImage, finishPoint.getY()*y, finishPoint.getX()*x, y, x, panel);
		g.drawImage(Playing.finishedImage, finishPoint.getY()*y, finishPoint.getX()*x, y, x, panel);
		
	}
}
