import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		User user=new User();
		Player player=new Player();
		boolean choose=true;
		Scanner scan= new Scanner(System.in);
		while(choose) 
		{
			System.out.print("Choose option : " + '\n');
			System.out.print("(1) Sign in " + '\n');
			System.out.print("(2) Login " + '\n');
			System.out.print("(3) Add Player " + '\n');
			System.out.print("(4) Add Squad " + '\n');
			System.out.print("(5) Exit " + '\n');
			String choise= scan.nextLine();
			switch (choise)
			{
				case ("1"):
				{
					user.SignedInUser();
					break;
				}
				case ("2"):
				{
					user.LogedInUser();
					break;
				}
				case ("3"):
				{
					player.addPlayer();
					break;
				}
				case ("4"):
				{
					player.addSquad();
					break;
				}
				default:
				{
					choose=false;
					break;
				}
			}
		}
	}
	}
