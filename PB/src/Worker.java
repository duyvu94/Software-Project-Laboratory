
public class Worker extends Thing{
	private int points;
	public boolean Move(Direction d){
		return false;
	}
	
	public void Die(){
		System.out.println("worker dies");
	}
	
	public boolean Pushed(Direction d, Worker k){
		System.out.println("Worker is pushed");
		return false;
	}
	
	public void GoToHole(){
		System.out.println("Worker goes to hole");
	}
}
