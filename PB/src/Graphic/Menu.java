package Graphic;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import Core.Game;

public class Menu extends JPanel{

	private JPanel panel;
	private Game game;
	
	private JLabel  txtTitle;
	
	private JLabel  txtNoPlayers;
	private JLabel  txtMap;
	private JTextField noOfPlayers;
	private JComboBox selectedMap;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnNewGame;
	private JButton btnExitGame;
	private Window window;
	

	/**
	 * Konstruktor, megtortenik a menu inicializalasa, majd kijelzese
	 */
	public Menu(Window w){
		InitMenu();
		ShowMenu();
		window = w;
	}

	/**
	 * Menu kijelzese. Az osszes gomb/szoveg/legordulo-menu megvalositasa itt talalhato.
	 * A panel layout-ja egy box, erre kerulnek elrendezesre az egyes elemek.
	 */
	public void ShowMenu(){
		javax.swing.Box box = javax.swing.Box.createVerticalBox();
		javax.swing.Box playerBox = javax.swing.Box.createHorizontalBox();
		
		panel = new JPanel();
		panel.setBackground(Color.orange);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		String maps[] = {"Map1","Map2", "Map3"};
		selectedMap = new JComboBox<String>(maps);
		selectedMap.setMaximumSize(new Dimension(130, 20));
		((JLabel)selectedMap.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		noOfPlayers = new JTextField(8);
		noOfPlayers.setText("2");
		noOfPlayers.setMaximumSize( noOfPlayers.getPreferredSize() );
		noOfPlayers.setHorizontalAlignment(JTextField.CENTER);
		noOfPlayers.setEditable(false);
		
		txtTitle = new JLabel("<html>BOX - MAN<br><center>GAME</html>", JLabel.CENTER);
		txtTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		txtTitle.setFont(new Font("Courier New", Font.BOLD, 38));
		
		txtMap = new JLabel("Select a map:", JLabel.CENTER);
		txtMap.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		txtNoPlayers = new JLabel("Number of players:", JLabel.CENTER);
		txtNoPlayers.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		box.add(javax.swing.Box.createVerticalStrut(40));
		box.add(txtTitle);
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

	/**
	 * A menun talalhato gombok megvalositasa, avagy mi tortenjen, ha az adott gombot megnyomtak
	 */
	public void InitMenu(){
		btnPlus = new JButton(new AbstractAction("+"){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int number = Integer.parseInt(noOfPlayers.getText())+1;
	        	if (number <= 4)
	        		noOfPlayers.setText(Integer.toString(number));
	        }
	    });
		btnMinus = new JButton(new AbstractAction("-"){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int number = Integer.parseInt(noOfPlayers.getText())-1;
	        	if (number > 0)
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
	
	/**
	 * Uj jatek inditasakor az uj jatek setupja itt tortenik
	 */
	public void NewGame(){
		try {
			game.ChooseLevel(selectedMap.getSelectedIndex()+1, Integer.parseInt(noOfPlayers.getText()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		window.setPlaying();
		game.startGame();
	}

	public void Exit(){
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

