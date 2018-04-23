
public class Hole extends Field{
	private boolean isOpen = true;
	
	public Hole(boolean status){
		isOpen = status;
	}
	
	public boolean MovableThrough(){
		return true;
	}
	
	public void Accept(Thing t){
		if (!isOpen){
			super.Accept(t);
		}
		if (t.AbleToTriggerSwitch())
			System.out.println("Box goes to hole");
		else
			System.out.println("Worker goes to hole");
		if (isOpen)
			t.GoToHole();
	}

	public void setOpen(boolean status){
		if (!status)
			System.out.println("Hole is closed");
		isOpen = status;
	}
	
	public String ToString(){
		if (GetCurrentThing() != null)
			return GetCurrentThing().ToString();
		else return "H";
	}
}
