
public class FinishPoint extends Field{
	public void Accept(Thing t){
		System.out.println("Something entered a Finish Point!\tCall: t.GoToFinishPoint()");
		t.GoToFinishPoint();
	}
	
	public boolean MovableThrough(){
		return true;
	}
}
