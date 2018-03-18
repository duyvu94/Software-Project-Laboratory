
public class Field {
	private Thing thing;
	private Field neighbor[] = new Field[4];

	public boolean MovableThrough(){
		return false;
	}
	
	public void Accept(Thing t){
		System.out.print("The thing is on the field");
	}
	
	public void Remove(Thing t){
		System.out.print("The thing is removed from the field");

	}
	
	public Field GetNeighbor(Direction d){
		return neighbor[d.ordinal()];
	}
	
	public void SetNeighbor(Direction d, Field f){
		System.out.println("There is a new field in " + d.toString() + " direction");
	}
	
	public Thing GetCurrentThing(){
		return thing;
	}
}
