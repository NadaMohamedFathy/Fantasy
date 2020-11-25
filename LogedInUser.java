import java.io.IOException;
import java.util.Scanner;

public class LogedInUser implements User{
	Files user_file=new Files();
	Scanner scan= new Scanner(System.in);
	public LogedInUser() {}
	public void register() throws IOException 
	{
		System.out.println("E-mail : ");
		String Email = scan.nextLine();
		System.out.println("Password : ");
		String Password = scan.nextLine();
		if(user_file.check(Email,Password))
		{
			System.out.println("You loged in sucessfully" + '\n');
		}
		else 
		{
			System.out.println("Faild.You may entered wrong password or you do not have an account" + '\n');
		}
		}
	}
