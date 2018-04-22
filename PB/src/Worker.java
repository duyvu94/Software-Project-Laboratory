
public class Worker extends Thing{
	private int points;
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean Move(Direction d){
		Field field = getField();
		Field nextField = field.GetNeighbor(d);
		if (nextField.MovableThrough()){
			Thing t = nextField.GetCurrentThing();
			if ( t != null ){
				if (!t.Pushed(d, this))
					return false;
			}
			
			field.Remove(this);
			nextField.Accept(this);
			System.out.println("Worker moves successfully!");
			return true;
		}
		return false;
	}
	
	public void Die(){
		System.out.println("Worker dies!");
	}
	
	public boolean Pushed(Direction d, Worker w){
		System.out.println("Worker is pushed!");
		Field field = getField();
		Field nextField = field.GetNeighbor(d);
		if (nextField.MovableThrough()){
			Thing t = nextField.GetCurrentThing();
			if ( t != null ){
				if (!t.Pushed(d, w)){
					Die();
					return true;
				}
			}
			
			field.Remove(this);
			nextField.Accept(this);
			
			return true;
		}
		Die();
		return false;
	}
	
	public void GoToHole(){
		System.out.println("Worker goes to hole!");
		Die();
	}
}
