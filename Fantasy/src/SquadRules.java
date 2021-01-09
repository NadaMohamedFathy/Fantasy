import java.io.IOException;

public abstract class SquadRules {

	Files player_file=new Files();
	public boolean applayRules(String fileName,String playerName) throws Exception
	{
		return false;
	}
	public int indexSearch(String playerName) throws IOException
	{
		int ind=-1;
		ind=player_file.search("Players.txt",playerName);
		if(ind>=0)
		{
			return ind;
		}
		return -1;
	}
}
