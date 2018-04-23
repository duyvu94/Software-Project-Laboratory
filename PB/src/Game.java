import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	public Storage storage;
	
	public Game(){
		
	}
	
	public void startGame(){
		System.out.println("Start game");
	}
	
	public void EndGame(){
		System.out.println("End game");
	}
	
	public void ChooseLevel(int level, int numberOfPlayers) throws IOException{
		storage = new Storage();

		BufferedReader br = new BufferedReader(new FileReader("Map" + level + ".txt"));
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
					game.ChooseLevel(Integer.parseInt(command[1]), 0);
					System.out.println("Map is loaded!");
					break;
				case "Connect":
					game.storage.ConnectFields(Integer.parseInt(command[2]), Integer.parseInt(command[4]), command[5]);
					break;
				case "Create":
					game.storage.Create(command);
					break;
				case "Wire":
					game.storage.Wire(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
					break;
				case "ViewMap":
					//need to do this
					break;
				case "PutOil":
					if (game.storage.getPlayers()[Integer.parseInt(command[1])-1].PutOil())
						System.out.println("Oil can be put on "+ command[1] +"’s position");
					else
						System.out.println("Oil can't be put on "+ command[1] +"’s position");
					
					break;
				case "PutHoney":
					if (game.storage.getPlayers()[Integer.parseInt(command[1])-1].PutHoney())
						System.out.println("Honey can be put on "+ command[1] +"’s position");
					else 
						System.out.println("Honey can't be put on "+ command[1] +"’s position");
					break;
				case "MoveWorker":
					game.storage.getPlayers()[Integer.parseInt(command[1])-1].Move(Direction.right);
					break;
				case "Exit":
					return;
				default:
					System.out.println("Unknown command!");
					return;
			}
		}
	}
}
