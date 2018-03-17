import java.util.Scanner;

public class Game {
	private Storage state[] = new Storage[100];
	
	public void startGame(){
		System.out.println("Start game");
	}
	
	public void EndGame(){
		System.out.println("End game");
	}
	
	public void ChooseLevel(int level, int numberOfPlayers){
		System.out.println("Choose Level");
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("This is a sample program using for demonstration");
		System.out.println("###############");
		System.out.println("#......H......#");
		System.out.println("#......B......#");
		System.out.println("#....FBWBBBBBw#");
		System.out.println("#......H......#");
		System.out.println("#......H......#");
		System.out.println("###############");
		System.out.println("Which direction do you want to move?Left/right/up/down(l/r/u/d)");
		
		
		
		
	}
}
