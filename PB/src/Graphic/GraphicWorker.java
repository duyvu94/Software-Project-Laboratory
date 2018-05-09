package Graphic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Core.Worker;

public class GraphicWorker implements Drawable{
	private Worker worker;
	private JLabel img;
	
	public GraphicWorker(Worker w){
		img = new JLabel();
		worker = w;
		
	}
	
	public JLabel getImage(){
		return img;
	}
	
	public void Draw(){
		int x = 800/worker.getStorage().getHeight(); 
		int y = 800/worker.getStorage().getWidth();
		img.setBounds(worker.getY()*y, worker.getX()*x, y, x);
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("man.png"));
		img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(y, x, Image.SCALE_SMOOTH)));
	}
}
