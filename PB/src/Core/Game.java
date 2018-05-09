package Core;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import Graphic.*;

public class Game implements KeyListener{
	private Storage storage;
	private Playing playing; 
	
	public Game() throws IOException{
	}
	
	public void startGame(){
		System.out.println("Start game");
		playing.DrawAll();
	}
	
	public void EndGame(){
		System.out.println("End game");
	}
	
	public void ChooseLevel(int level, int numberOfPlayers) throws IOException{
		storage = new Storage();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("map"+ level + ".txt").getFile());
		Scanner scanner = new Scanner(file);
		//read size
		int x = scanner.nextInt();  
		int y = scanner.nextInt();
		storage.setSize(x, y);
		
		//read map
		for (int i = 0; i < x; i++){	
			String line = scanner.next();
			for (int j = 0; j < y; j++){
				Drawable d = storage.readField(i, j, line.charAt(j));
				playing.getDrawablesList().add(d);
				playing.getPanel().add(d.getImage());
			}
		}
		
		//read players' location
		for (int i = 1; i<=4; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			if (i <= numberOfPlayers){
				Worker worker = new Worker(x, y, storage);
				storage.addPlayer(x, y, worker);
				GraphicWorker gw = new GraphicWorker(worker);			
				playing.getDrawablesList().add(gw);
				playing.getPanel().add(gw.getImage());
				
			}
		}
		
		//read boxes
		int boxes = scanner.nextInt();
		for (int i = 0; i < boxes - 1; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			Box b = new Box(x, y, storage);
			storage.getField(x, y).Accept(b);
		}
		
		//read oil
		int oil = scanner.nextInt();
		for (int i = 0; i < oil - 1; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			storage.getField(x, y).setFriction(1);
		}
		
		//read honey
		int honey = scanner.nextInt();
		for (int i = 0; i < honey - 1; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			storage.getField(x, y).setFriction(3);
		}
		
		//make connections betwen switches and holes
		int switchesAndHoles = scanner.nextInt();
		for (int i = 0; i < honey - 1; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			storage.Wire(x, y, x1, y1);
		}
		
		scanner.close();
	}
	
	
	public Playing getPlaying() {
		return playing;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
            playing.DrawAll();
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String args[]) throws IOException{
		Window window = new Window("BoxMan");
		Playing playing = new Playing();
		Menu menu = new Menu();
		Game game = new Game();
		
		menu.setGame(game);
		game.setPlaying(playing);
		
		window.setMenu(menu);
		window.setPlaying(playing);
		window.SetUp();
		window.Run();
		
	}
}
