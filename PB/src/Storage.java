import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Storage {
	private Field fields[] = new Field[150];
	private Game game;
	private List<Worker> players = new ArrayList<Worker>();
	private List<Hole> holesList = new ArrayList<Hole>();
	private List<Switch> switchesList = new ArrayList<Switch>();
	private int column = 0;
	
	//private 
	
	public Storage() throws IOException{
		
	}
	
	public Worker getPlayer(int index) {
		return players.get(index);
	}

	public void addPlayer(Worker worker){
		players.add(worker);
	}

	//Betoltjük a mezoket a map fajlunkbol
	//A mezok csak a mazok tulajdonsagait tartalmazzak
	//	Ures   = .
	//	Mezes  = h
	//	Olajos = o
	public void LoadFields(String loadedFields){
		column = loadedFields.length();
		
		for (int i = 0; i < loadedFields.length(); i++) {
			fields[i] = new Field();
			switch (loadedFields.charAt(i)){
				case 'h':
					fields[i].setFriction(3);
					break;
				case 'o':
					fields[i].setFriction(1);
					break;
				default:
					fields[i].setFriction(2);
					break;
			}
		}
	}

	public String ViewMap(){
		String map = "";
		for(int i = 0; i< column; i++){
			map += fields[i].ToString();
		}
		return map;
	}

	public void Create(String command[]){
		int location = Integer.parseInt(command[4]);
		int id = Integer.parseInt(command[2]);
		switch (command[1]){
			case "Box":
				Box b = new Box();
				b.setID(id);
				fields[location].Accept(b);
				break;
			case "Worker":
				Worker w = new Worker();
				w.setID(id);
				w.setHoneyContainer(Integer.parseInt(command[5]));
				w.setOilContainer(Integer.parseInt(command[6]));
				addPlayer(w);
				fields[location].Accept(w);
				break;
			case "Hole":
				Hole hole = new Hole();
				hole.setOpen(command[5] == "open" ? true: false);
				hole.setId(id);
				holesList.add(hole);
				fields[location] = hole;
				ConnectFields(location, location+1, "right");
				ConnectFields(location+1, location, "left");
				if (location != 0){
					ConnectFields(location-1, location, "right");
					ConnectFields(location, location-1, "left");
				}
				break;
			case "Wall":
				fields[location] = new Wall();
				ConnectFields(location, location+1, "right");
				ConnectFields(location+1, location, "left");
				if (location != 0){
					ConnectFields(location-1, location, "right");
					ConnectFields(location, location-1, "left");
				}
				break;
			case "Switch":
				Switch swi = new Switch();
				swi.setId(id);
				switchesList.add(swi);
				fields[location] = swi;
				ConnectFields(location, location+1, "right");
				ConnectFields(location+1, location, "left");
				if (location != 0){
					ConnectFields(location-1, location, "right");
					ConnectFields(location, location-1, "left");
				}
				break;
			case "FinishPoint":
				FinishPoint finish = new FinishPoint();
				finish.setId(id);
				fields[location] = finish;
				ConnectFields(location, location+1, "right");
				ConnectFields(location+1, location, "left");
				if (location != 0){
					ConnectFields(location-1, location, "right");
					ConnectFields(location, location-1, "left");
				}
				break;
			default:
				System.out.println("Thing does not exists!");
				return;
		}
	}
	//Osszekot egy mezot egy masik mezovel (szomszedossa teszi oket)
	//Kesobb majd egy map-et fogunk erre használni, most az egyszeruseg kedveert a kovetkezokepp bontottuk le:
	//	0 = balra,
	//	1 = jobbra,
	//	2 = felfele,
	//	3 = lefele
	//iranyba kapcsoljuk az elso mezot a masodikhoz.
	public void ConnectFields(int field1, int field2, String dir){
		if (dir == "left")
			fields[field1].SetNeighbor(Direction.left, fields[field2]);
		else
			fields[field1].SetNeighbor(Direction.right, fields[field2]);
	}
	
	public void Wire(int swi, int hole){
		switchesList.get(swi-1).addHole(holesList.get(hole-1));
	}
}
