
public class Wall extends Field{
	public boolean MovableThrough(){
		System.out.println("Not a possible move through a wall!");
		return false;
	}
}
