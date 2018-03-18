
public class Box extends Thing{
	public boolean Pushed(Direction d, Worker w){
		return true;
	}
	
	public boolean AbleToTriggerSwitch(){
		return true;
	}
	
	public void GoToHole(){
		System.out.println("box goes to hole");
		
	}
	
	public void GoToFinishPoint(){
		System.out.println("box goes to finishpoint");
	}
}
