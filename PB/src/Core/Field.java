package Core;

public class Field {
	private Thing thing;
	private Field neighbor[] = new Field[4];
	private int friction;
	private int x, y;
	private Storage storage;
	
	/**
	 * Konstruktor, alapertelmezetten uresen jon letre a mezo (2-es erteku surlodas)
	 */
	public Field(int x, int y){
		friction = 2;
		this.x = x;
		this.y = y;
	}
	
	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setFriction(int newFriction){
		friction = newFriction;
	}

	public int GetFriction(){
		return friction;
	}


	public boolean MovableThrough(){
		return true;
	}
 
	public void Accept(Thing t){
		this.thing = t;
		t.setField(this);
	}
 
	public void Remove(Thing t){
		this.thing = null;

	}
 
	public Field GetNeighbor(Direction d){
		return neighbor[d.ordinal()];
	}
 
	public void SetNeighbor(Direction d, Field f){
		neighbor[d.ordinal()] = f;
	}
 
	public Thing GetCurrentThing(){
		return thing;
	}
	
	public String ToString(){
		if (thing != null)
			return thing.ToString();
		else return ".";
	}
}