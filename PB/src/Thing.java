
public class Thing {
	private Worker pushedBy;
	private Field field;
	
	
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public boolean Pushed(Direction d, Worker w){
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
