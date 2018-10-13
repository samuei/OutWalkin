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
		}
		catch (Exception Err){
			System.out.println("Uh oh. Looks like the world file is malformed.");
			System.out.println("Message : " + Err.getMessage());
			System.out.println("Type    : " + Err.toString());
			scanner.close();
			return;
		}
		
		System.out.println("I have a world!");
		System.out.println("Where would you like to go?");
		world.longDisplay(cur);
		
		do {
			System.out.print("\n>");
			cmd = new String(scanner.next());
			// TODO: This can probably be better handled as a hashmap.
			if(cmd.equals("n") || cmd.equals("north")){
				cur = world.goN(cur);
				world.longDisplay(cur);
			}
			else if (cmd.equals("s") || cmd.equals("south")){
				cur = world.goS(cur);
				world.longDisplay(cur);
			}
			else if (cmd.equals("e") || cmd.equals("east")){
				cur = world.goE(cur);
				world.longDisplay(cur);
			}
			else if (cmd.equals("w") || cmd.equals("west")){
				cur = world.goW(cur);
				world.longDisplay(cur);
			}
			else if (cmd.equals("l") || cmd.equals("look")) {
				world.shortDisplay(cur);
			}
			else if (cmd.equals("exits")) {
				System.out.println(world.getExits(cur));
			}
			else if (cmd.equals("quit")){
				gameloop = false;
			}
			else {
				System.out.println("I'm sorry. I don't understand what you meant.");
			}

		}
		while (gameloop);
		
		System.out.println("Thanks for walking with me.");
		scanner.close();
		return;
	}
	

}
