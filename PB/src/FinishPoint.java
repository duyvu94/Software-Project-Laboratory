
public class FinishPoint extends Field{
	public void Accept(Thing t){
		if (t.AbleToTriggerSwitch()){
			System.out.println("A box entered the Finish Point!");
			t.GoToFinishPoint();
		}
	}
	
	public boolean MovableThrough(){
		return true;
	}
}
