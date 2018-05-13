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

import Core.Switch;

public class GraphicSwitch implements Drawable{
	private Switch sw;
	private BufferedImage image, backgroundImage;
	
	public GraphicSwitch(Switch s){
		sw = s;
		URL resource = getClass().getClassLoader().getResource("switch.png");
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
		int x = 800/sw.getStorage().getHeight(); 
		int y = 800/sw.getStorage().getWidth();
		g.drawImage(backgroundImage, sw.getY()*y, sw.getX()*x, y, x, panel);
		g.drawImage(image, sw.getY()*y, sw.getX()*x, y, x, panel);
		
	}
}
