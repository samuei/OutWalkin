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
		// TODO: Compiler error due to not having a World class built:
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
			cmd = scanner.next();
			// I'd love to use a switch, here, but JDK6 :(
			if(cmd == "n" || cmd == "north"){
				cur = world.goN(cur);
			}
			else if (cmd == "s"||cmd=="south"){
				cur = world.goS(cur);
			}
			else if (cmd == "e"||cmd=="east"){
				cur = world.goE(cur);
			}
			else if (cmd == "w"||cmd=="west"){
				cur = world.goW(cur);
			}
			else if (cmd=="quit"){
				gameloop = false;
			}

		}
		while(gameloop);
		System.out.println("Thanks for walking with me.");
		scanner.close();
	}
	

}