import java.util.Scanner;

public class OutWalkin {

	public static void main(String[] args) {
		boolean gameloop = true;
		Scanner scanner = new Scanner(System.in);
		String cmd;
		World world = null;
		int cur = 0;
		System.out.println("Let's go walking!");
		
		if(args.length == 0)
	    {
			System.out.println("Dear God! There's no world! The world is empty!");
			System.out.println("Remember to include the world as an argument next time, like this:");
			System.out.println("\tOutWalkin rooms.txt");
			scanner.close();
			return;
	    }
	    
		try{
			String worldfile = args[0];
			world = new World(worldfile);
			System.out.println("I have a world!");
		}
		catch (Exception Err){
			System.out.println("Uh oh. Looks like the world is malformed.");
			Err.printStackTrace(System.out);
			scanner.close();
			return;
		}
		
		System.out.println("Where would you like to go?");
		world.longDisplay(cur);
		
		do {
			System.out.print("\n>");
			cmd = new String(scanner.next());
			// TODO: This can still probably be better handled as a hashmap.
			switch (cmd) {
				case "n":
				case "north":
					cur = world.goN(cur);
					world.longDisplay(cur);
					break;
				case "s":
				case "south":
					cur = world.goS(cur);
					world.longDisplay(cur);
					break;
				case "e":
				case "east":
					cur = world.goE(cur);
					world.longDisplay(cur);
					break;
				case "w":
				case "west":
					cur = world.goW(cur);
					world.longDisplay(cur);
					break;
				case "l":
				case "look":
					world.shortDisplay(cur);
					break;
				case "exits":
					System.out.println(world.getExits(cur));
					break;
				case "quit":
					gameloop = false;
					break;
				default:
					System.out.println("I'm sorry. I don't understand what you meant.");
			}
		}
		while (gameloop);
		
		System.out.println("Thanks for walking with me.");
		scanner.close();
		return;
	}
	

}
