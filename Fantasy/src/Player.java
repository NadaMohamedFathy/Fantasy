import java.io.IOException;
import java.util.Scanner;

public class Player {

	Files player_file=new Files();
	PlayerInfo playerinfo;
	User user=new User();
	Scanner scan= new Scanner(System.in);
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
		System.out.println("Height : ");
		double Height = scan.nextDouble();
		System.out.println("Price : ");
		double price = scan.nextDouble();
		System.out.println("Appearances : ");
		int Appearances = scan.nextInt();
		System.out.println("Goals : ");
		int Goals = scan.nextInt();
		System.out.println("Wins : ");
		int Wins = scan.nextInt();
		System.out.println("Losses : ");
		int Losses = scan.nextInt();
		System.out.println("CleanSheets : ");
		int CleanSheets = scan.nextInt();
		playerinfo=new PlayerInfo(name,nationality,position,club,Date_of_Birth,Height,price,Appearances,Goals,Wins,Losses,CleanSheets);
		player_file.writeFile(playerinfo);
		System.out.println("You entered the player sucessfully" + '\n');
	}
	public void addSquad() throws IOException
	{
		System.out.println("Login : ");
		int index=user.LogedInUser();
		if(index!=0)
		{
			System.out.println("Squad Size\r\n" + 
					"To join the game select a fantasy football squad of 15 players, consisting of:\r\n" + 
					"\r\n" + 
					"* 2 Goalkeepers\r\n" + 
					"* 5 Defenders\r\n" + 
					"* 5 Midfielders\r\n" + 
					"* 3 Forwards\r\n" + 
					"Budget\r\n" + 
					"The total value of your initial squad must not exceed £100 million.\r\n" + 
					"\r\n" + 
					"Players Per Team\r\n" + 
					"You can select up to 3 players from a single Premier League team.");
			String userfile=player_file.UserFile(index);
			player_file.displayFile("Players.txt");
			while(true)
			{
				int n=player_file.checkNOPinSquad(userfile);
				if(n==15)
				{
					break;
				}
				System.out.println("Enter name of the player you want to add to your squad : ");
				String name= scan.nextLine();
				player_file.checkSqaudRules(userfile,name);
			}
		}
		else
		{
			System.out.println("You cannot add squad" + '\n');
		}
	}
}
