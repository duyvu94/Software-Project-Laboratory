
public class Hole extends Field{
	private boolean isOpen = true;
	
	public boolean MovableThrough(){
		return true;
	}
	
	public void Accept(Thing t){
		System.out.println("Something entered a Hole! If the Hole is in open state, that may be a problem for you...");
		if (isOpen)
			t.GoToHole();
	}

	public void setOpen(boolean status){
		System.out.println("Hole's state has been changed");
		isOpen = status;
	}
}
