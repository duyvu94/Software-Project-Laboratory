package Graphic;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame{
	private Menu menu;
	private Playing playing;
	
	public Window(String name){
		super(name);
	}
	
	public void SetUp(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(820,850));
		getContentPane().add(playing.getPanel(), BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	public void Run(){
		menu.NewGame();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Playing getPlaying() {
		return playing;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}
	
}
