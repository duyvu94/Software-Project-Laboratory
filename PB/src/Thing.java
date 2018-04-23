
public class Thing {
	private Worker pushedBy;
	private Field field;
	private int ID;
	

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public boolean Pushed(Direction d, Worker w, int totalFiction){
		return true;
	}
	
	public void GoToHole(){
		
	}
	
	public void GoToFinishPoint(){
		
	}
	
	public void AddPointToWorker(){
		
	}
	
	public boolean AbleToTriggerSwitch(){
		return false;
	}
}
