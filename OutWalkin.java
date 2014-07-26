import java.util.Scanner;
import java.io.IOException;
public class OutWalkin {

	public static void main(String[] args) {
		boolean gameloop = true;
		Scanner scanner = new Scanner(System.in);
		String cmd;
		World world = null;
		// TODO: Magic number due to not having save game functionality:
		int cur = 0;
		System.out.println("Let's go walking!");
		// TODO: Yell at user for not having a World file selected
		try{
			world = new World(args[0]);
		}
		catch (IOException Err){
			System.exit(-1);
		}
		System.out.println("I have a world!");
		do{
			world.display(cur);
			System.out.println("Where would you like to go?");
			cmd = new String(scanner.next());
			// I'd love to use a switch, here, but JDK6 :(
			if(cmd.equals("n") || cmd.equals("north")){
				cur = world.goN(cur);
			}
			else if (cmd.equals("s")||cmd.equals("south")){
				cur = world.goS(cur);
			}
			else if (cmd.equals("e")||cmd.equals("east")){
				cur = world.goE(cur);
			}
			else if (cmd.equals("w")||cmd.equals("west")){
				cur = world.goW(cur);
			}
			else if (cmd.equals("quit")){
				gameloop = false;
			}

		}
		while(gameloop);
		System.out.println("Thanks for walking with me.");
		scanner.close();
	}
	

}
