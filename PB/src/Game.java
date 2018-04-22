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
		storage = new Storage();
		
		BufferedReader br = new BufferedReader(new FileReader("Map"+ level +".txt"));
		try {
			String line = br.readLine();

		} finally {
		    br.close();
		}
	}
	
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		while (true){
			String text = scanner.nextLine();
			String command[] = text.split(" ");
			switch (command[0]){
				case "LoadMap":
					
					System.out.println("Map is loaded!");
					break;
				case "":
					break;
				default:
					System.out.println("Unknown command!");
					return;
			}
		}
	}
}
