
public class Field {
	private Thing thing;
	private Field neighbor[] = new Field[4];
	private int friction;


	//Konstruktor, alapértelmezetten üresen jön létre a mező (2-es értékű súrlódás)
	public Field(){
		friction = 2;
	}

	public void setFriction(int sliperiness){
		friction = sliperiness;
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
