package Core;

public class FinishPoint extends Field{
	
	public FinishPoint(int x, int y){
		super(x, y);
	}
	
	public void Accept(Thing t){
		if (t.AbleToTriggerSwitch()){
			t.GoToFinishPoint();
		}
		else
			super.Accept(t);
	}
	
	public boolean MovableThrough(){
		return true;
	}
	
	public String ToString(){
		if (GetCurrentThing() != null)
			return GetCurrentThing().ToString();
		else return "F";
	}
	
	
}
