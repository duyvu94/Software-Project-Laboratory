package Graphic;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Core.Worker;

public class Playing extends JPanel{
	
	private List<Drawable> drawablesList;
	private boolean isPlaying;
	private List<Worker> workersList;
	static public BufferedImage layout, fieldImage, boxImage, closedHoleImage, finishedImage,
		holeImage, honeyImage, oilImage, switchImage, wallImage, worker0Image, worker1Image,
		worker2Image, worker3Image, worker4Image;
	
	public List<Drawable> getDrawablesList() {
		return drawablesList;
	}

	public void setDrawablesList(List<Drawable> drawablesList) {
		this.drawablesList = drawablesList;
	}
	
	public List<Worker> getWorkersList() {
		return workersList;
	}

	public void setWorkersList(List<Worker> workersList) {
		this.workersList = workersList;
	}
	
	public void loadResource(){
		try{
			layout= ImageIO.read(getClass().getClassLoader().getResource("layout.png"));
			fieldImage = ImageIO.read(getClass().getClassLoader().getResource("field.jpg"));
			boxImage = ImageIO.read(getClass().getClassLoader().getResource("box.png"));
			closedHoleImage = ImageIO.read(getClass().getClassLoader().getResource("closedhole.png"));
			finishedImage= ImageIO.read(getClass().getClassLoader().getResource("finish.png"));
			holeImage = ImageIO.read(getClass().getClassLoader().getResource("hole.png"));
			honeyImage= ImageIO.read(getClass().getClassLoader().getResource("honey.png"));
			oilImage= ImageIO.read(getClass().getClassLoader().getResource("oil.png"));
			switchImage= ImageIO.read(getClass().getClassLoader().getResource("switch.png"));
			wallImage= ImageIO.read(getClass().getClassLoader().getResource("wall.png"));
			worker0Image= ImageIO.read(getClass().getClassLoader().getResource("worker0.png"));
			worker1Image= ImageIO.read(getClass().getClassLoader().getResource("worker1.png"));
			worker2Image= ImageIO.read(getClass().getClassLoader().getResource("worker2.png"));
			worker3Image= ImageIO.read(getClass().getClassLoader().getResource("worker3.png"));
			worker4Image= ImageIO.read(getClass().getClassLoader().getResource("worker4.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Playing(){
		loadResource();
		drawablesList = new ArrayList<Drawable>();
		setFocusable(true);
		setLayout(null);
		setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw game over
        if (!isPlaying){
        	g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 50));
        	g.setColor(Color.black);
        	g.drawString("GameOver", 550, 100);
        	g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 20));
        	g.drawString("(Press Escape to go back to the main menu)", 460, 130);
        	g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 20));
        	g.setColor(Color.red);
        	for (int i = 0; i< 4; i++){
        		switch (i){
        			case 0: g.setColor(Color.red); break;
        			case 1: g.setColor(Color.blue); break;
        			case 2: g.setColor(Color.green); break;
        			case 3: g.setColor(Color.pink); break;
        			default: break;
        		}
    	    	if (workersList.size() > i){
    		    	g.drawString("Player "+ (i+1) +": " +workersList.get(i).getPoints(), 620, 250+i*50);
    		    }
        	}
        	return;
        }
        
        //draw the game's components
        g.drawImage(layout, 800, 0, 550, 800, this);
        int fontSize = 20;
		g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, fontSize));
	    g.setColor(Color.red);
	    for (int i = 0; i< 4; i++)
	    	if (workersList.size() > i){
		    	g.drawString(workersList.get(i).getPoints()+"", 1060, 37+i*200);
		    	g.drawString(workersList.get(i).getOilContainer()+"", 115, 37+i*200);
		    	g.drawString(workersList.get(i).getHoneyContainer()+"", 1250, 37+i*200);
		    }
		for(Drawable d : drawablesList){
			d.Draw(g, this);
		}
		
	}

	public void DrawAll(boolean playing){
		isPlaying = playing;
		repaint();
	}
}
