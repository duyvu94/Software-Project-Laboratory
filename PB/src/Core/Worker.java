package Core;
/**
 * Represents a Box element
 */
public class Worker extends Thing{
	/**
	 * Azok az attributumok, melyekkel az adott munkas rendelkezik
	 * 	hany pontot kapott eddig a jatekos
	 * 	mekkora erovel bír a munkas
	 * 	pl. hany db. mezet/olajat tud lerakni
	 */
	private int points = 0;
	private int strength = 4;
	private int oilContainer = 0;
	private int honeyContainer = 0;
	
	public Worker(int x, int y, Storage s){
		super(x, y, s);
	}
	
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
	 * Lekerdezi a jelenlegi pontszamot
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Beallitja a pontokat
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * A kivant iranyba probalja meg leptetni a munkast
	 */
	public boolean Move(Direction d){
		  Field field = getField();
		  Field nextField = field.GetNeighbor(d);
		  if (nextField.MovableThrough()){
		   Thing t = nextField.GetCurrentThing();
		   if ( t != null ){
		    if (!t.AbleToTriggerSwitch()){
		     return false;
		    }
		    if (!t.Pushed(d, this, 0))
		     return false;
		   }
		   field.Remove(this);	// Move to the new field
		   nextField.Accept(this);
		   return true;
		  }
		  return false;
	 }
	
	// Put oil to the field
	public boolean PutOil(){
		if (oilContainer == 0)
			return false;
		oilContainer--;
		getField().setFriction(1);
		return true;
	}
	
	// Put honey to the field
	public boolean PutHoney(){
		if (honeyContainer == 0)
			return false;
		honeyContainer--;
		getField().setFriction(3);
		return true;
	}
	
	/**
	 * Ez fut le, mikor meghal a munkas
	 */
	public void Die(){
		
	}
	
	/**
	 * Ez fut le, amikor egy munkast megtolnak.
	 * 	megj.: masik munkas nem tud munkast tolni
	 */
	public boolean Pushed(Direction d, Worker w, int totalFiction){
		Field field = getField();
		if (field.GetFriction() + totalFiction > w.getStrength())
			return false;
		Field nextField = field.GetNeighbor(d);
		if (nextField.MovableThrough()){	// ha tudunk lepni a kovetkezo mezore (nem fal)
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
		Die();	//ha a munkas dobozok koze/ dobozok és egy fal koze szorul, meghal
		return true;
	}
	
	/**
	 * Meghivodik, ha lyukba leptunk/toltak minket
	 */
	public void GoToHole(){
		System.out.println("Worker goes to hole");
		Die();
	}
	
	/**
	 * Show the symbol representing for object
	 */
	public String ToString(){
		return "W";
	}
	
	/**
	 * Give point to the player
	 */
	public void PlusPoint(){
		  
	 }
}
