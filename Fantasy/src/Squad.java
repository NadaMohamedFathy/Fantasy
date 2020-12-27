import java.io.IOException;
import java.util.Scanner;

public class Squad {

	Files player_file=new Files();
	User user=new User();
	Scanner scan= new Scanner(System.in);
	public Squad() {}
	public void addSquad() throws IOException
	{
		System.out.println("Login : ");
		int index=user.LogedInUser();
		if(index>=0)
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
				checkSqaudRules(userfile,name);
			}
		}
		else
		{
			System.out.println("You cannot add squad" + '\n');
		}
	}
	public void checkSqaudRules(String fileName,String playerName) throws IOException//b3ml check 3la el rules el awl abl ma aktb el player f el file
	{
		//int index=player_file.search("Players.txt",playerName);
		int ind=-1;
		ind=player_file.search("Players.txt",playerName);//index bta3 el player w mnha el club bta3o hykon ind+2 w el position bta3o ind+3
		if(ind>=0)
		{
			String club=player_file.array.get(ind+2);//club of player
			String position=player_file.array.get(ind+3);//position of player
			String price=player_file.array.get(ind+6);
			double priceOfPlayer=Double.parseDouble(price);
			int inde=player_file.search("Users.txt",fileName);
			String budget=player_file.array.get(inde+1);
			double budgetOfUser=Double.parseDouble(budget);
			player_file.checknumberOfPlayers(fileName,club);
			player_file.checkPosition(fileName,position);
			if(budgetOfUser!=0.0 && budgetOfUser>priceOfPlayer && player_file.numberOfPlayers<3 && player_file.numberOfGoalkeepers<2 && position.equals("Goalkeeper"))
			{
				player_file.writeFile(fileName,playerName,budgetOfUser,priceOfPlayer,inde);
			}
			else if(budgetOfUser!=0.0 && budgetOfUser>priceOfPlayer && player_file.numberOfPlayers<3 && player_file.numberOfForwards<3 && position.equals("Forward"))
			{
				player_file.writeFile(fileName,playerName,budgetOfUser,priceOfPlayer,inde);
			}
			else if(budgetOfUser!=0.0 && budgetOfUser>priceOfPlayer && player_file.numberOfPlayers<3 && player_file.numberOfMidfielders<5 && position.equals("Midfielder"))
			{
				player_file.writeFile(fileName,playerName,budgetOfUser,priceOfPlayer,inde);
			}
			else if(budgetOfUser!=0.0 && budgetOfUser>priceOfPlayer && player_file.numberOfPlayers<3 && player_file.numberOfDefenders<5 && position.equals("Defender"))
			{
				player_file.writeFile(fileName,playerName,budgetOfUser,priceOfPlayer,inde);
			}
			else
			{
				System.out.println("You cannot add this player to your squad");
			}
		}
		else
		{
			System.out.println("You may entered the name of the player wrong or entered name of player that is not in the system.");
		}
		
	}
}
