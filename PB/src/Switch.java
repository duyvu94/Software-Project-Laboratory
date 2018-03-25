
public class Switch extends Field{
	private Hole holes[] = new Hole[100];
	
	public boolean MovableThrough(){
		return true;
	}
	
	public void Accept(Thing t){
		System.out.println("Something arrives to the switch.\tCall if(t.AbleToTriggerSwitch()) => hols.setOpen(true)");

		if (t.AbleToTriggerSwitch()){
			foreach (var hole in holes){
				hole.setOpen(true);
			}
		}
	}
	
	public void Remove(Thing t){
		System.out.println("Something leaves the switch.\tCall if(t.AbleToTriggerSwitch()) => hole.setOpen(false)");

		if (t.AbleToTriggerSwitch()){
			foreach (var hole in holes){
				hole.setOpen(false);
			}
		}
	}
}
