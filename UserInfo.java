
public class UserInfo {

	 public String name ;
	 public String email;
	 public String password;
	 public String favourite_premier_league_team;
	 public String filename;
	 public double budget;
	 public UserInfo() 
	 {
		  this.name = "";
		  this.email= "";
		  this.password= "";
		  this.favourite_premier_league_team= "";
		  this.filename="";
		  this.budget=0.0;
	 }
	public UserInfo(String name,String email,String password,String favourite_premier_league_team,String filename,double budget) 
	 {
		  this.name=name;
		  this.email=email;
		  this.password=password;
		  this.favourite_premier_league_team=favourite_premier_league_team;
		  this.filename=filename;
		  this.budget=budget;
	 }
	public String getName()
	{
		return this.name;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getFavourite_Premier_League_Team()
	{
		return this.favourite_premier_league_team;
	}
	public String getFilename()
	{
		return this.filename;
	}
	public double getBudget()
	{
		return this.budget;
	}
}