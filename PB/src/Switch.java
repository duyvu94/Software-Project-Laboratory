
public class Switch extends Field{
	private Hole holes[] = new Hole[100];
	private int numberOfHoles = 0;
	
	public void addHole(Hole h){
		holes[numberOfHoles++] = h;
	}
	
	public boolean MovableThrough(){
		return true;
	}
	
	public void Accept(Thing t){
		if (t.AbleToTriggerSwitch()){
			System.out.println("A box arrives to the switch.");
			for(int i = 0; i< numberOfHoles; i++){
				holes[i].setOpen(true);
			}
		}
	}
	
	public void Remove(Thing t){
		if (t.AbleToTriggerSwitch()){
			System.out.println("A box leaves the switch.");
			for(int i = 0; i< numberOfHoles; i++){
				holes[i].setOpen(false);
			}
		}
	}
	
	public String ToString(){
		if (GetCurrentThing() != null)
			return GetCurrentThing().ToString();
		else return "S";
	}
}
