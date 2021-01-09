import java.io.IOException;
import java.util.Scanner;

public class Player {

	Files player_file=new Files();
	PlayerInfo playerinfo;
	Scanner scan= new Scanner(System.in);
	Scanner scan1= new Scanner(System.in);
	public Player() {}
	public void addPlayer() throws IOException
	{
		System.out.println("Name : ");
		String name = scan.nextLine();
		System.out.println("Nationality : ");
		String nationality = scan.nextLine();
		System.out.println("Position : ");
		String position = scan.nextLine();
		System.out.println("Club : ");
		String club = scan.nextLine();
		System.out.println("Date_of_Birth : ");
		String Date_of_Birth = scan.nextLine();
		System.out.println("Height (cm) : ");
		double Height = scan1.nextDouble();
		System.out.println("Price : ");
		double price = scan1.nextDouble();
		/*System.out.println("Appearances : ");
		int Appearances = scan.nextInt();
		System.out.println("Goals : ");
		int Goals = scan.nextInt();
		System.out.println("Wins : ");
		int Wins = scan.nextInt();
		System.out.println("Losses : ");
		int Losses = scan.nextInt();
		System.out.println("CleanSheets : ");
		int CleanSheets = scan.nextInt();*/
		//,Appearances,Goals,Wins,Losses,CleanSheets
		playerinfo=new PlayerInfo(name,nationality,position,club,Date_of_Birth,Height,price,0);
		player_file.writeFile(playerinfo);
		System.out.println("You entered the player sucessfully" + '\n');
	}
}
