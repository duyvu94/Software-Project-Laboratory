
public class Box extends Thing{
	public boolean Pushed(Direction d, Worker w){
		System.out.println("Box is pushed!");
		Field field = getField();
		Field nextField = field.GetNeighbor(d);
		if (nextField.MovableThrough()){
			Thing t = nextField.GetCurrentThing();
			if ( t != null ){
				if (!t.Pushed(d, w)){
					return false;
				}
			}
			
			field.Remove(this);
			nextField.Accept(this);
			
			return true;
		}
		return false;
	}
	
	public boolean AbleToTriggerSwitch(){
		return true;
	}
	
	public void GoToHole(){
		System.out.println("Box goes to hole!");
		
	}
	
	public void GoToFinishPoint(){
		System.out.println("Box goes to finishpoint!");
	}
}
