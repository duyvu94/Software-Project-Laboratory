package Core;
public class Thing {
	protected Worker pushedBy;
	private Field field;
	private int x, y;
	private Storage storage;
	
	public Thing(int x, int y, Storage s){
		this.x = x;
		this.y = y;
		storage = s;
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
		  pushedBy.PlusPoint();
	 }
	
	public boolean AbleToTriggerSwitch(){
		return false;
	}
	
	public String ToString(){
		return null;
	}
}
