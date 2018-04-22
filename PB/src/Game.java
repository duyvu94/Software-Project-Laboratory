import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	private Storage storage;
	
	public void startGame(){
		System.out.println("Start game");
	}
	
	public void EndGame(){
		System.out.println("End game");
	}
	
	public void ChooseLevel(int level, int numberOfPlayers) throws IOException{
		
	}
	
	public void LoadMap(String map) throws IOException{
		storage = new Storage();
		
		BufferedReader br = new BufferedReader(new FileReader(map));
		try {
			String line = br.readLine();
			storage.LoadFields(line);

		} finally {
		    br.close();
		}
	}
	
	public static void main(String args[]) throws IOException{
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		while (true){
			String text = scanner.nextLine();
			String command[] = text.split(" ");
			switch (command[0]){
				case "LoadMap":
					game.LoadMap(command[1]);
					System.out.println("Map is loaded!");
					break;
				case "Connect":
					
					break;
				default:
					System.out.println("Unknown command!");
					return;
			}
		}
	}
}
