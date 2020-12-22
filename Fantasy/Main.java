import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		User user;
		boolean choose=true;
		Scanner scan= new Scanner(System.in);
		while(choose) 
		{
			System.out.print("Choose option : " + '\n');
			System.out.print("(1) Sign in " + '\n');
			System.out.print("(2) Login " + '\n');
			System.out.print("(3) Exit " + '\n');
			String choise= scan.nextLine();
			switch (choise)
			{
				case ("1"):
				{
					user=new SignedInUser();
					user.register();
					break;
				}
				case ("2"):
				{
					user=new LogedInUser();
					user.register();
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
