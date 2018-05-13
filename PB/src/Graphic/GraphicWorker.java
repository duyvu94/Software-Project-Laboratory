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
	
	public GraphicWorker(Worker w){
		worker = w;
	}
	
	public void Draw(Graphics g, JPanel panel) {
		if (!worker.isDisplayed())
			return;
		int x = 800/worker.getStorage().getHeight(); 
		int y = 800/worker.getStorage().getWidth();
		
		BufferedImage image;
		
		switch(worker.getID()){
			case 1: image = Playing.worker1Image; break;
			case 2: image = Playing.worker2Image; break;
			case 3: image = Playing.worker3Image; break;
			case 4: image = Playing.worker4Image; break;
			default: image = Playing.worker0Image; break;
		}
		
		g.drawImage(image, worker.getY()*y, worker.getX()*x, y, x, panel);
		
	}
}
