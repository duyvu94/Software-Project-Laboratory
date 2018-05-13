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
	private BufferedImage image, backgroundImage;
	
	public GraphicFinishPoint(FinishPoint fp){
		finishPoint = fp;
		URL resource = getClass().getClassLoader().getResource("finish.png");
		URL resource1 = getClass().getClassLoader().getResource("field.jpg");
        try {
            image = ImageIO.read(resource);
            backgroundImage = ImageIO.read(resource1);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public BufferedImage getImage(){
		return image;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		int x = 800/finishPoint.getStorage().getHeight(); 
		int y = 800/finishPoint.getStorage().getWidth();
		g.drawImage(backgroundImage, finishPoint.getY()*y, finishPoint.getX()*x, y, x, panel);
		g.drawImage(image, finishPoint.getY()*y, finishPoint.getX()*x, y, x, panel);
		
	}
}
