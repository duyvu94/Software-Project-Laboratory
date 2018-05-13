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
	private Window window;
	public enum GameState{
		ready, playing, gameover
	}
	
	private GameState state;
	
	public Game(Window w) throws IOException{
		state = GameState.ready;
		window = w;
	}
	
	public void startGame(){
		System.out.println("Start game");
		state = GameState.playing;
		playing.DrawAll(true);
		
	}
	
	public void EndGame(){
		System.out.println("End game");
		window.setMenu();
	}
	
	/**
	 * Egy uj jatek inditasakor itt tortenik meg a palya betoltese, es annak
	 * osszes funkcionalitasanak beallitasa
	 * Minden ehhez szukseges informacio a mapX.txt fajlokban talalhato meg.
	 */
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
			}
		}
		
		//read players' location
		int strength = scanner.nextInt();
		int oilContainer = scanner.nextInt();;
		int honeyContainer = scanner.nextInt();
		storage.setNumberOfAliveWorkers(numberOfPlayers);
		for (int i = 1; i<=4; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			if (i <= numberOfPlayers){
				Worker worker = new Worker(x, y, storage);
				worker.setHoneyContainer(honeyContainer);
				worker.setOilContainer(oilContainer);
				worker.setStrength(strength);
				worker.setID(i);
				storage.addPlayer(x, y, worker);
				GraphicWorker gw = new GraphicWorker(worker);			
				playing.getDrawablesList().add(gw);
			}
		}
		storage.ConnectAllFields();
		playing.setWorkersList(storage.getPlayers());
		
		//read boxes
		int boxes = scanner.nextInt();
		storage.setNumberOfAliveBoxes(boxes);
		for (int i = 0; i < boxes; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			Box b = new Box(x, y, storage);
			storage.getField(x, y).Accept(b);
			GraphicBox gb = new GraphicBox(b);
			playing.getDrawablesList().add(gb);
		}
		
		//read oil
		int oil = scanner.nextInt();
		for (int i = 0; i < oil; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			storage.getField(x, y).setFriction(1);
		}
		
		//read honey
		int honey = scanner.nextInt();
		for (int i = 0; i < honey; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			storage.getField(x, y).setFriction(3);
		}
		
		//make connections between switches and holes
		int switchesAndHoles = scanner.nextInt();
		for (int i = 0; i < switchesAndHoles; i++){
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

	/**
	 * A munkasok iranyitasa, billentyuzeten a gomb-kiosztas megvalositasa
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.out.println("escape");
			EndGame();
		}
		
		if (state != GameState.playing ){
			return;
		}
		
		
			
		if (storage.getPlayer(0) != null && storage.getPlayer(0).isDisplayed()){
			switch (arg0.getKeyCode()){
				case KeyEvent.VK_W:
					storage.getPlayer(0).Move(Direction.up);
					break;
				case KeyEvent.VK_S:
					storage.getPlayer(0).Move(Direction.down);
					break;
				case KeyEvent.VK_A:
					storage.getPlayer(0).Move(Direction.left);
					break;
				case KeyEvent.VK_D:
					storage.getPlayer(0).Move(Direction.right);
					break;
				case KeyEvent.VK_Z:
					storage.getPlayer(0).PutOil();
					break;
				case KeyEvent.VK_X:
					storage.getPlayer(0).PutHoney();
					break;
				default: break;
			}
        }
		
		if (storage.getPlayer(1) != null && storage.getPlayer(1).isDisplayed()){
			switch (arg0.getKeyCode()){
				case KeyEvent.VK_UP:
					storage.getPlayer(1).Move(Direction.up);
					break;
				case KeyEvent.VK_DOWN:
					storage.getPlayer(1).Move(Direction.down);
					break;
				case KeyEvent.VK_LEFT:
					storage.getPlayer(1).Move(Direction.left);
					break;
				case KeyEvent.VK_RIGHT:
					storage.getPlayer(1).Move(Direction.right);
					break;
				case KeyEvent.VK_SEMICOLON:
					storage.getPlayer(1).PutOil();
					break;
				case KeyEvent.VK_QUOTE:
					storage.getPlayer(1).PutHoney();
					break;
				default: break;
			}
        }
		
		if (storage.getPlayer(2) != null && storage.getPlayer(2).isDisplayed()){
			switch (arg0.getKeyCode()){
				case KeyEvent.VK_U:
					storage.getPlayer(2).Move(Direction.up);
					break;
				case KeyEvent.VK_J:
					storage.getPlayer(2).Move(Direction.down);
					break;
				case KeyEvent.VK_H:
					storage.getPlayer(2).Move(Direction.left);
					break;
				case KeyEvent.VK_K:
					storage.getPlayer(2).Move(Direction.right);
					break;
				case KeyEvent.VK_B:
					storage.getPlayer(2).PutOil();
					break;
				case KeyEvent.VK_N:
					storage.getPlayer(2).PutHoney();
					break;
				default: break;
			}
        }
		
		if (storage.getPlayer(3) != null && storage.getPlayer(3).isDisplayed()){
			switch (arg0.getKeyCode()){
				case KeyEvent.VK_NUMPAD8:
					storage.getPlayer(3).Move(Direction.up);
					break;
				case KeyEvent.VK_NUMPAD5:
					storage.getPlayer(3).Move(Direction.down);
					break;
				case KeyEvent.VK_NUMPAD4:
					storage.getPlayer(3).Move(Direction.left);
					break;
				case KeyEvent.VK_NUMPAD6:
					storage.getPlayer(3).Move(Direction.right);
					break;
				case KeyEvent.VK_NUMPAD1:
					storage.getPlayer(3).PutOil();
					break;
				case KeyEvent.VK_NUMPAD2:
					storage.getPlayer(3).PutHoney();
					break;
				default: break;
			}
        }
		if (storage.getNumberOfAliveBoxes() != 0 && storage.getNumberOfAliveWorkers() !=0)
			playing.DrawAll(true);
		else
			playing.DrawAll(false);
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
		Window window = new Window("BoxMen");
		Playing playing = new Playing();
		Menu menu = new Menu(window);
		Game game = new Game(window);
		
		menu.setGame(game);
		game.setPlaying(playing);
		playing.addKeyListener(game);
		
		window.setMenu(menu);
		window.setPlaying(playing);
		window.SetUp();
		window.Run();
		
	}
}
