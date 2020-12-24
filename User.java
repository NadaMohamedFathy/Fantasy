import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class User {
	Files user_file=new Files();
	UserInfo userinfo;
	Scanner scan= new Scanner(System.in);
	public User() {}
	public void SignedInUser() throws IOException
	{
		System.out.println("Name : ");
		String name = scan.nextLine();
		System.out.println("E-mail : ");
		String email = scan.nextLine();
		System.out.println("Password : ");
		String password = scan.nextLine();
		System.out.println("Your Favourite Premier League Team : ");
		String favourite_premier_league_team = scan.nextLine();
		String file=name+".txt";
		userinfo=new UserInfo(name,email,password,favourite_premier_league_team,file,100000000.0);
		/*if(user_file.file.exists())
		{*/
				if(user_file.check(userinfo.email))
				{
					System.out.println("Faild.There is an account with this mail." + '\n');
				}
				else
				{
					user_file.writeFile(userinfo);
				    System.out.println("You signed in sucessfully" + '\n');
				    File userFile=new File(file);
				    userFile.createNewFile();
				}
		/*}
		else
		{
			user_file.file.createNewFile();
			user_file.writeFile(userinfo);
			System.out.println("You signed in sucessfully" + '\n');
		}*/
		
	}
	public int LogedInUser() throws IOException 
	{
		System.out.println("E-mail : ");
		String Email = scan.nextLine();
		System.out.println("Password : ");
		String Password = scan.nextLine();
		int x=-1;
		x=user_file.check(Email,Password);
		if(x>=0)
		{
			System.out.println("You loged in sucessfully" + '\n');
			return x;
		}
		else 
		{
			System.out.println("Faild.You may entered wrong password or you do not have an account" + '\n');
			return -1;
		}
		}
}
