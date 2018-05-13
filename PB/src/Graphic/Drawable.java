package Graphic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

public interface Drawable {
	
	public void Draw(Graphics g, JPanel panel);
}
