
public class CalculateBudget {

	public String calculateBudget(String fileName,String playerName) throws Exception
	{
		Files player_file=new Files();
		int ind=-1;
		ind=player_file.search("Players.txt",playerName);//index bta3 el player w mnha el club bta3o hykon ind+2 w el position bta3o ind+3
		if(ind>=0)
		{
			String price=player_file.array.get(ind+6);
			double priceOfPlayer=Double.parseDouble(price);
			int inde=player_file.search("Users.txt",fileName);
			String budget=player_file.array.get(inde+1);
			double budgetOfUser=Double.parseDouble(budget);
			double newBudget=budgetOfUser-priceOfPlayer;
			String newBudgetOfUser=String.format("%f",newBudget);
			return newBudgetOfUser;
		}
		return "You have little budget";
	}
}
