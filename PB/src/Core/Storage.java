package Core;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Graphic.*;

public class Storage {
	private Field fields[][] = new Field[20][20];
	private int sizeX, sizeY;
	private Game game;
	private List<Worker> players = new ArrayList<Worker>();
	private List<Hole> holesList = new ArrayList<Hole>();
	private List<Switch> switchesList = new ArrayList<Switch>();
	
	
	/**
	 * Instructor
	 */
	public Storage() throws IOException{
		
	}
	
	public void setSize(int x, int y){
		sizeX = x;
		sizeY = y;
	}
	
	public int getHeight(){
		return sizeX;
	}
	
	public int getWidth(){
		return sizeY;
	}
	/**
	 * get the worker based on the index
	 */
	public Worker getPlayer(int index) {
		return players.get(index);
	}

	/**
	 * Add more player to the list
	 */
	public void addPlayer(int x, int y, Worker worker){
		fields[x][y].Accept(worker);
		players.add(worker);
	}
	
	public Drawable readField(int i, int j, char c){
		switch(c){
			case '#': 
				Wall wall = new Wall(i, j);
				wall.setStorage(this);
				fields[i][j] =  wall;
				return new GraphicWall(wall);
			case 'S': 
				Switch s = new Switch(i, j); 
				s.setStorage(this);
				fields[i][j] = s;
				return new GraphicSwitch(s);
			case 'H': 
				Hole hole = new Hole(i, j, true);
				hole.setStorage(this);
				fields[i][j] = hole; 
				return new GraphicHole(hole);
			case 'F': 
				FinishPoint finishPoint = new FinishPoint(i, j);
				finishPoint.setStorage(this);
				fields[i][j] = finishPoint; 
				return new GraphicFinishPoint(finishPoint);
			default : 
				Field field = new Field(i, j);
				field.setStorage(this);
				fields[i][j] = field;
				return new GraphicField(field);
		}
	}
	
	public Field getField(int x, int y){
		return fields[x][y];
	}
	
	public void Wire(int x, int y, int x1, int y1){
		for(Switch s : switchesList){
			for (Hole h : holesList){
				if (s.getX() == x && s.getY() == y && h.getX() == x1 && h.getY() == y1){
					s.addHole(h);
				}
			}
		}
	}
	
}
