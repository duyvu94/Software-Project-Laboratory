package Core;

/**
 * Represents a Box element
 */
public class Box extends Thing{
	
	/**
	 * Egy doboz tolasra kerul, ami tovabbi dolgokat tol el adott esetekben
	 */
	public Box(int x, int y, Storage s){
		super(x, y, s);
	}
	
	public boolean Pushed(Direction d, Worker w, int totalFiction){
		pushedBy = w;
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
			setX(nextField.getX());
			setY(nextField.getY());
			return true;
		}
		return false;
	}
	
	/**
	 * Egy doboz mindig aktivalhat kapcoslokat
	 */
	public boolean AbleToTriggerSwitch(){
		return true;
	}
	
	/**
	 * Lefut, ha a doboz lyukhoz er
	 */
	public void GoToHole(){
		setDisplayed(false);
		getStorage().setNumberOfAliveBoxes(getStorage().getNumberOfAliveBoxes()-1);
		System.out.println("Box goes to hole!");
		
	}
	
	
	/**
	 * Lefut, ha a dobozt celhelyre sikerult juttatni
	 */
	public void GoToFinishPoint(){
		setDisplayed(false);
		AddPointToWorker();
		getStorage().setNumberOfAliveBoxes(getStorage().getNumberOfAliveBoxes()-1);
		System.out.println("Box goes to finishpoint");
	 }
	
	public String ToString(){
		return "B";
	}
}
