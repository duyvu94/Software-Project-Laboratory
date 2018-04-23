
public class Wall extends Field{
	public boolean MovableThrough(){
		System.out.println("Not a possible move through a wall!");
		return false;
	}
	
	public String ToString(){
		if (GetCurrentThing() != null)
			return GetCurrentThing().ToString();
		else return "W";
	}
}
