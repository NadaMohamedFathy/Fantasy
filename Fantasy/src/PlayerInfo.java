
public class PlayerInfo {

	public String name;
	public String nationality;
	public String position;
	public String club;
	public String Date_of_Birth;
	public double Height;
	public double price;
	public int points;
	/*public int Appearances;
	public int Goals;
	public int Wins;
	public int Losses;
	public int CleanSheets;*/
	
	public PlayerInfo() 
	{
		this.name="";
		this.nationality="";
		this.position="";
		this.club="";
		this.Date_of_Birth="";
		this.Height=0.0;
		this.price=0.0;
		this.points=0;
		/*this.Appearances=0;
		this.Goals=0;
		this.Wins=0;
		this.Losses=0;
		this.CleanSheets=0;*/
	}
	//,int Appearances,int Goals,int Wins,int Losses,int CleanSheets
	public PlayerInfo(String name,String nationality,String position,String club,String Date_of_Birth,double Height,double price,int points)
	{
		this.name=name;
		this.nationality=nationality;
		this.position=position;
		this.club=club;
		this.Date_of_Birth=Date_of_Birth;
		this.Height=Height;
		this.price=price;
		this.points=points;
		/*this.Appearances= Appearances;
		this.Goals= Goals;
		this.Wins= Wins;
		this.Losses= Losses;
		this.CleanSheets=CleanSheets;*/
	}
	public String getName()
	{
		return this.name;
	}
	public String getNationality()
	{
		return this.nationality;
	}
	public String getPosition()
	{
		return this.position;
	}
	public String getClub()
	{
		return this.club;
	}
	public String getDate_of_Birth()
	{
		return this.Date_of_Birth;
	}
	public double getHeight()
	{
		return this.Height;
	}
	public double getPrice()
	{
		return this.price;
	}
	public int getPoints()
	{
		return this.points;
	}
	/*public int getAppearances()
	{
		return this.Appearances;
	}
	public int getGoals()
	{
		return this.Goals;
	}
	public int getWins()
	{
		return this.Wins;
	}
	public int getLosses()
	{
		return this.Losses;
	}
	public int getCleanSheets()
	{
		return this.CleanSheets;
	}*/

}
