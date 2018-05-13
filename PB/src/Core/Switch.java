package Core;
public class Switch extends Field{
	private Hole holes[] = new Hole[100];
	private int numberOfHoles = 0;
	
	public Switch(int x, int y){
		super(x, y);
	}
	
	public void addHole(Hole h){
		holes[numberOfHoles++] = h;
	}
	
	public boolean MovableThrough(){
		return true;
	}
	
	public void Accept(Thing t){
		System.out.println(numberOfHoles);
		super.Accept(t);
		if (t.AbleToTriggerSwitch()){
			for(int i = 0; i< numberOfHoles; i++){
				if (holes[i].isOpened())
					holes[i].setOpen(false);
				else
					holes[i].setOpen(true);
			}
		}
	}
	
	public void Remove(Thing t){
		super.Remove(t);
		if (t.AbleToTriggerSwitch()){
			System.out.println("A box leaves the switch.");
			for(int i = 0; i< numberOfHoles; i++){
				if (holes[i].isOpened())
					holes[i].setOpen(false);
				else
					holes[i].setOpen(true);
			}
		}
	}
	
	public String ToString(){
		if (GetCurrentThing() != null)
			return GetCurrentThing().ToString();
		else return "S";
	}
}
