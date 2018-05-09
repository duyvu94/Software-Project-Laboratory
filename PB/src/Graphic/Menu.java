package Graphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.*;

import Core.Game;

public class Menu{
	JPanel panel;
	Game game;
	
	
	JLabel  txtNoPlayers;
	JLabel  txtMap;
	
	JTextField noOfPlayers;
	JComboBox selectedMap;
	
	JButton btnPlus;
	JButton btnMinus;
	JButton btnNewGame;
	JButton btnExitGame;
	
	public Menu(){
		InitMenu();
		ShowMenu();
	}
	
	public void ShowMenu(){
    	
		javax.swing.Box box = javax.swing.Box.createVerticalBox();
		javax.swing.Box playerBox = javax.swing.Box.createHorizontalBox();
	
		panel = new JPanel();
		panel.setBackground(Color.orange);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		String maps[] = {"map1","map2", "map3"};
		
		
		selectedMap = new JComboBox<String>(maps);
		selectedMap.setMaximumSize(new Dimension(130, 20));
		((JLabel)selectedMap.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		noOfPlayers = new JTextField(8);
		noOfPlayers.setText("2");
		noOfPlayers.setMaximumSize( noOfPlayers.getPreferredSize() );
		noOfPlayers.setHorizontalAlignment(JTextField.CENTER);
		noOfPlayers.setEditable(false);
		
		
		txtMap = new JLabel("Select a map:", JLabel.CENTER);
		txtMap.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		txtNoPlayers = new JLabel("Number of players:", JLabel.CENTER);
		txtNoPlayers.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		
		box.add(javax.swing.Box.createVerticalStrut(130));
		box.add(txtMap);
		box.add(selectedMap);
		box.add(javax.swing.Box.createVerticalStrut(10));
		box.add(txtNoPlayers);
		
		
			playerBox.add(btnMinus);
			playerBox.add(noOfPlayers);
			playerBox.add(btnPlus);
		
			
		box.add(playerBox);
		box.add(javax.swing.Box.createVerticalStrut(30));
		box.add(btnNewGame);
		box.add(javax.swing.Box.createVerticalStrut(30));
		box.add(btnExitGame);
		
		btnMinus.setMaximumSize(new Dimension(20, 20));
		btnPlus.setMaximumSize(new Dimension(20, 20));
		btnNewGame.setMaximumSize(new Dimension(200, 40));
		btnExitGame.setMaximumSize(new Dimension(200, 40));
		
		btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnExitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(box, BorderLayout.CENTER);
		
    }
	
	private void InitMenu(){
		btnPlus = new JButton(new AbstractAction("+"){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int number = Integer.parseInt(noOfPlayers.getText())+1;
	        	if (number <= 8)
	        		noOfPlayers.setText(Integer.toString(number));
	        }
	    });
		btnMinus = new JButton(new AbstractAction("-"){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int number = Integer.parseInt(noOfPlayers.getText())-1;
	        	if (number > 1)
	        		noOfPlayers.setText(Integer.toString(number));
	        }
	    });
		btnNewGame = new JButton(new AbstractAction("New Game"){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	NewGame();
	        }
	    });
		btnExitGame = new JButton( new AbstractAction("Exit") {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Exit();
	        }
	    });
	}
	
	void NewGame(){
		try {
			game.ChooseLevel(selectedMap.getSelectedIndex()+1, Integer.parseInt(noOfPlayers.getText()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		game.startGame();
	}
	
	void Exit(){
		System.exit(0);
	}
	public JPanel getPanel() {
		return panel;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
