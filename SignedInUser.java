import java.io.IOException;
import java.util.Scanner;

public class SignedInUser implements User{
	Files user_file=new Files();
	Scanner scan= new Scanner(System.in);
	public SignedInUser() {}
	public void register() throws IOException
	{
		System.out.println("Name : ");
	    user_file.name = scan.nextLine();
		System.out.println("E-mail : ");
		user_file.email = scan.nextLine();
		System.out.println("Password : ");
		user_file.password = scan.nextLine();
		System.out.println("Your Favourite Premier League Team : ");
		user_file.favourite_premier_league_team = scan.nextLine();
		if(user_file.file.exists())
		{
				if(user_file.check(user_file.email))
				{
					System.out.println("Faild.There is an account with this mail." + '\n');
				}
				else
				{
					user_file.writeFile(user_file.user_path("Users.txt"));
				    System.out.println("You signed in sucessfully" + '\n');
				}
		}
		else
		{
			user_file.file.createNewFile();
			user_file.writeFile(user_file.user_path("Users.txt"));
			System.out.println("You signed in sucessfully" + '\n');
		}
		
	}
	}

