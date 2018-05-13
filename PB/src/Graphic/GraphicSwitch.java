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
	
	public GraphicSwitch(Switch s){
		sw = s;
	}

	public void Draw(Graphics g, JPanel panel) {
		int x = 800/sw.getStorage().getHeight(); 
		int y = 800/sw.getStorage().getWidth();
		g.drawImage(Playing.fieldImage, sw.getY()*y, sw.getX()*x, y, x, panel);
		g.drawImage(Playing.switchImage, sw.getY()*y, sw.getX()*x, y, x, panel);
		
	}
}
