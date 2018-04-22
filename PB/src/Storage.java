import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Storage {
	private Field fields[] = new Field[150];
	private Game game;
	private Worker players[] = new Worker[4];
	
	//private 
	
	public Storage() throws IOException{
		
	}
	
	//Betöltjük a mezőket a map fájlunkból
	//A mezők csak a mazők tulajdonságait tartalmazzák
	//	Üres   = .
	//	Mézes  = h
	//	Olajos = o
	public void LoadFields(String loadedFields){
		for (int i = 0; i < loadedFields.Length(); i++) 
			switch (loadedFields[i]){
				case "h":
					fields[i].setFriction(3);
					break;
				case "o":
					fields[i].setFriction(1);
					break;
				default:
					System.out.println("Unknown command!");
					return;
			}
		}
	}



	public void CreateThing(String thing, int id, int column){
		switch (thing){
			case "Box":
				Box b = new Box();
				b.setID(id);
				fields[column].Accept(b);
				break;
			case "Worker":
				fields[column].Accept(players[id]);
				break;
			default:
				System.out.println("Thing does not exists!");
				return;
		}
	}

	public void CreateField(String field, int column){
		switch (field){
			case "FinishPoint":
				FinishPoint newField = new FinishPoint();
				for (int i = 0; i < 3; i++){
					fields[column].Accept(players[id]);
				}
				break;
			case "Hole":
				Box b = new Box();
				b.setID(id);
				fields[column].Accept(b);
				break;
			case "Switch":
				fields[column].Accept(players[id]);
				break;
			case "Wall":
				fields[column].Accept(players[id]);
				break;
			default:
				System.out.println("Thing does not exists!");
				return;
		}
	}

	
	//Összeköt egy mezőt egy másik mezővel (szomszédossá teszi őket)
	//Később majd egy map-et fogunk erre használni, most az egyszerűség kedvéért a következőképp bontottuk le:
	//	0 = balra,
	//	1 = jobbra,
	//	2 = felfelé,
	//	3 = lefelé
	//irányba kapcsoljuk az első mezőt a másodikhoz.
	public void ConnectFields(int field1, int field2, Direction dir){
		switch (dir){
			case left:
				fields[field1].neighbor[0] = fields[field2]
				break;
			case right:
				fields[field1].neighbor[1] = fields[field2]
				break;
			case up:
				fields[field1].neighbor[2] = fields[field2]
				break;
			case down:
				fields[field1].neighbor[3] = fields[field2]
				break;
			default:
				System.out.println("Unknown command!");
				return;
		}
	}
}
