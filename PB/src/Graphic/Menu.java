package Graphic;

import java.io.IOException;

import javax.swing.JPanel;

import Core.Game;

public class Menu{
	JPanel panel;
	Game game;
	
	public Menu(){
		panel = new JPanel();
	}
	
	void NewGame(){
		try {
			game.ChooseLevel(1, 1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		game.startGame();
	}
	
	void Exit(){
		
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
