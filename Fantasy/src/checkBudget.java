

public class checkBudget extends SquadRules
{

	public boolean applayRules(String fileName,String playerName) throws Exception
	{
		int ind=-1;
		ind=indexSearch(playerName);//index bta3 el player w mnha el club bta3o hykon ind+2 w el position bta3o ind+3
		if(ind>=0)
		{
			String price=player_file.array.get(ind+6);
			double priceOfPlayer=Double.parseDouble(price);
			int inde=player_file.search("Users.txt",fileName);
			String budget=player_file.array.get(inde+1);
			double budgetOfUser=Double.parseDouble(budget);
			if(budgetOfUser>=priceOfPlayer)
			{
				return true;
			}
		}
		return false;
	}
}
