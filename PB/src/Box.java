/**
 * Represents a Box element
 */
public class Box extends Thing{
	
	/**
	 * The box is pushed, this may push the thing in the next field
	 */
	public boolean Pushed(Direction d, Worker w, int totalFiction){
		System.out.println("Box is pushed");
		Field field = getField();
		//System.out.println(field.GetFriction() + totalFiction +" " + w.getStrength());
		
		if (field.GetFriction() + totalFiction > w.getStrength())
			return false;
		Field nextField = field.GetNeighbor(d);
		if (nextField.MovableThrough()){	// if the next thing is not a wall
			Thing t = nextField.GetCurrentThing();
			if ( t != null ){
				if (!t.Pushed(d, w, field.GetFriction() + totalFiction)){
					return false;
				}
			}
			
			field.Remove(this);
			nextField.Accept(this);
			
			return true;
		}
		return false;
	}
	
	/**
	 * Box is always able to trigger switches
	 */
	public boolean AbleToTriggerSwitch(){
		return true;
	}
	
	/**
	 * Triggered when box goes to hole
	 */
	public void GoToHole(){
		System.out.println("Box goes to hole!");
		
	}
	
	
	/**
	 * Triggered when box goes to finish point
	 */
	public void GoToFinishPoint(){
		System.out.println("Box goes to finishpoint!");
	}
	
	public String ToString(){
		return "B";
	}
}
