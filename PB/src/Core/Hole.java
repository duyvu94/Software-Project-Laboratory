package Core;

public class Hole extends Field{
	private boolean isOpen = true;
	
	/**
	 * Instructor
	 */
	public Hole(int x, int y, boolean status){
		super(x, y);
		isOpen = status;
	}
	
	/**
	 * Everything can pass the hole
	 */
	public boolean MovableThrough(){
		return true;
	}
	
	/**
	 * Accept a thing to hole
	 */
	public void Accept(Thing t){
	  if (!isOpen){
		  super.Accept(t);
	  }
	  else
		  t.GoToHole();
	}
	
	/**
	 * Set the status of the hole (open/close)
	 */
	public void setOpen(boolean status){
		if (!status)
			System.out.println("Hole is closed");
		else
			System.out.println("Hole is opened");
		isOpen = status;
	}
	
	/**
	 * Show the symbol representing for object
	 */
	public String ToString(){
		if (GetCurrentThing() != null)
			return GetCurrentThing().ToString();
		else return "H";
	}
}
