import java.io.*;

public class World {
	private Room[] Rooms;
	// World file specifications:
	// First line must be an integer >= 0 indicating the number of rooms.
	// Each room must be in the format of a room description, followed by
	// a pound sign (#) on its own line, followed by the room numbers, in
	// order, of the rooms to the North, East, South, and West on separate
	// lines. For non-exits, use -1.

	public World (String filename)throws IOException{
	    String returnValue = "";
	    FileReader file = null;
	    String line = "0";
	    //Room[] Rooms;
	    try {
	      file = new FileReader(filename);
	      BufferedReader reader = new BufferedReader(file);
	      line = reader.readLine();
	      int numRms = Integer.parseInt(line);
		Rooms = new Room[numRms];
	      for(int k = 0; k<numRms;k++){
	    	  // returnValue, after this loop, holds the room desc.
		      while ((line = reader.readLine()) != "#") {
		        returnValue += line + "\n";
		      }
		  Rooms[k].desc = returnValue;
		  Rooms[k].nroom = Integer.parseInt(reader.readLine());
		  Rooms[k].eroom = Integer.parseInt(reader.readLine());
		  Rooms[k].sroom = Integer.parseInt(reader.readLine());
		  Rooms[k].wroom = Integer.parseInt(reader.readLine());
		reader.close();
	      }
	      }
	      finally {
		if (file != null){
			file.close();
			}
		}
	    }
	

	public int goN(int cur){
		if(Rooms[cur].nroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return Rooms[cur].nroom;
		}
	}

	public int goE(int cur){
		if(Rooms[cur].eroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return Rooms[cur].eroom;
		}
	}

	public int goS(int cur){
		if(Rooms[cur].sroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return Rooms[cur].sroom;
		}
	}

	public int goW(int cur){
		if(Rooms[cur].wroom == -1){
			System.out.println("You can't go that way!");
			return cur;
		}
		else{
			return Rooms[cur].wroom;
		}
	}

	public void display (int cur){
		System.out.print(Rooms[cur].desc);
	}

}
