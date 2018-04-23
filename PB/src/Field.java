public class Field {
	private Thing thing;
	private Field neighbor[] = new Field[4];
	private int friction;
	private int id = 0;
	
 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Konstruktor, alapertelmezetten uresen jon letre a mezo (2-es erteku serlodas)
	public Field(){
		friction = 2;
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
}