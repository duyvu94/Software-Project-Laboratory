package Core;
public class Wall extends Field{
	
	public Wall(int x, int y){
		super(x, y);
	}
	
	public boolean MovableThrough(){
		return false;
	}
	
	public String ToString(){
		if (GetCurrentThing() != null)
			return GetCurrentThing().ToString();
		else return "X";
	}
}
