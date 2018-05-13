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

import Core.Worker;

public class GraphicWorker implements Drawable{
	private Worker worker;
	private BufferedImage image;
	
	public GraphicWorker(Worker w){
		worker = w;
		URL resource = getClass().getClassLoader().getResource("worker"+worker.getID()+".png");
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void Draw(Graphics g, JPanel panel) {
		if (!worker.isDisplayed())
			return;
		int x = 800/worker.getStorage().getHeight(); 
		int y = 800/worker.getStorage().getWidth();
		g.drawImage(image, worker.getY()*y, worker.getX()*x, y, x, panel);
		
	}
}
