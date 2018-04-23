/**
 * Represents a Box element
 */
public class Worker extends Thing{
	/**
	 * Points that the player have
	 */
	private int points = 0;
	private int strength = 4;
	private int oilContainer = 0;
	private int honeyContainer = 0;
	
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getOilContainer() {
		return oilContainer;
	}

	public void setOilContainer(int oilContainer) {
		this.oilContainer = oilContainer;
	}

	public int getHoneyContainer() {
		return honeyContainer;
	}

	public void setHoneyContainer(int honeyContainer) {
		this.honeyContainer = honeyContainer;
	}

	/**
	 * Get the points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Set the points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Move the worker by desired direction
	 */
	public boolean Move(Direction d){
		Field field = getField();
		Field nextField = field.GetNeighbor(d);
		if (nextField.MovableThrough()){
			Thing t = nextField.GetCurrentThing();
			if ( t != null ){
				if (!t.Pushed(d, this, 0))
					return false;
			}
			
			field.Remove(this);
			nextField.Accept(this);
			return true;
		}
		return false;
	}
	
	public boolean PutOil(){
		if (oilContainer == 0)
			return false;
		oilContainer--;
		getField().setFriction(1);
		return true;
	}
	
	public boolean PutHoney(){
		if (honeyContainer == 0)
			return false;
		honeyContainer--;
		getField().setFriction(3);
		return true;
	}
	
	/**
	 * Triggered when worker dies
	 */
	public void Die(){
		System.out.println("Worker dies!");
	}
	
	/**
	 * Triggered when worker is pushed
	 */
	public boolean Pushed(Direction d, Worker w, int totalFiction){
		Field field = getField();
		if (field.GetFriction() + totalFiction > w.getStrength())
			return false;
		Field nextField = field.GetNeighbor(d);
		if (nextField.MovableThrough()){	// if the next field is not a wall
			Thing t = nextField.GetCurrentThing();
			if ( t != null ){
				if (!t.Pushed(d, w, field.GetFriction() + totalFiction)){
					Die();
					return true;
				}
			}
			
			field.Remove(this);
			nextField.Accept(this);
			
			return true;
		}
		Die();	//if the worker is stuck between wall and other box, it will die
		return false;
	}
	
	/**
	 * Triggered when worker goes to hole
	 */
	public void GoToHole(){
		System.out.println("Worker goes to hole!");
		Die();
	}
	
	public String ToString(){
		return "W";
	}
}
