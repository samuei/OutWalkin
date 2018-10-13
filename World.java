import java.io.*;

public class World {
	private Room[] Rooms;

	public World (String filename)throws IOException{
		String returnValue = "";
		FileReader file = null;
		String line = "0";
		try {
			file = new FileReader(filename);
			BufferedReader reader = new BufferedReader(file);
			line = reader.readLine();
			int numRms = Integer.parseInt(line);
			Rooms = new Room[numRms];
			
			for(int k = 0; k < numRms; k++){
				Rooms[k] = new Room();
				returnValue = "";
				
				// First, assign the room's name
				line = reader.readLine();
				Rooms[k].setName(line);
				line = reader.readLine();
				
				// returnValue, after this loop, holds the room desc.
				while (!(line.equals("#"))) {
					returnValue += line + "\n";
					line = reader.readLine();
				}
				line = "";
				// Assign the rest of the room's values
				Rooms[k].setDesc(returnValue);
				Rooms[k].setNroom(Integer.parseInt(reader.readLine()));
				Rooms[k].setEroom(Integer.parseInt(reader.readLine()));
				Rooms[k].setSroom(Integer.parseInt(reader.readLine()));
				Rooms[k].setWroom(Integer.parseInt(reader.readLine()));
			}
			reader.close();
		}
		finally {
			if (file != null){
				file.close();
			}
		}
	}
	

	public int goN(int cur){
		int nroom = Rooms[cur].getNroom();
		if(nroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return nroom;
		}
	}

	public int goE(int cur){
		int eroom = Rooms[cur].getEroom();
		if(eroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return eroom;
		}
	}

	public int goS(int cur){
		int sroom = Rooms[cur].getSroom();
		if(sroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return sroom;
		}
	}

	public int goW(int cur){
		int wroom = Rooms[cur].getWroom();
		if(wroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return wroom;
		}
	}

	public void longDisplay (int cur) {
		System.out.println(Rooms[cur].getName());
		System.out.println(Rooms[cur].getDesc());
		System.out.println(getExits(cur));
	}
	
	public void shortDisplay (int cur) {
		System.out.println(Rooms[cur].getName());
	}
	
	public String getExits (int cur) {
		String exits = new String("Exits: ");
		boolean anyExits = false;
		if(Rooms[cur].getNroom() >= 0) {
			exits += "\nNorth";
			anyExits = true;
		}
		if (Rooms[cur].getEroom() >= 0) {
			exits += "\nEast";
			anyExits = true;
		}
		if (Rooms[cur].getSroom() >= 0) {
			exits += "\nSouth";
			anyExits = true;
		}
		if (Rooms[cur].getWroom() >= 0) {
			exits += "\nWest";
			anyExits = true;
		}
		if (!anyExits) {
			exits += "\nNone";
		}
		
		return exits;
	}

}
