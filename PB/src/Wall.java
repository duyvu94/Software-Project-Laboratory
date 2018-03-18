
public class Wall extends Field{
	public boolean MovableThrough(){
		System.out.println("Not a possible move, there is a wall in that direction.");
		return false;
	}
}
