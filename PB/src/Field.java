
public class Field {
	private Thing thing;
	private Field neighbor[] = new Field[4];

	public boolean MovableThrough(){
		return true;
	}
	
	public void Accept(Thing t){
		
	}
	
	public void Remove(Thing t){
		
	}
	
	public Field GetNeighbor(Direction d){
		return null;
	}
	
	public void SetNeighbor(Direction d, Field f){
		
	}
	
	public Thing GetCurrentThing(){
		return null;
	}
}
