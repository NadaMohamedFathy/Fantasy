import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class checknumberOfPlayers extends SquadRules
{

	static int numberOfPlayers=0;
	public boolean applayRules(String fileName,String playerName) throws Exception
	{
		int ind=-1;
		ind=indexSearch(playerName);//index bta3 el player w mnha el club bta3o hykon ind+2 w el position bta3o ind+3
		if(ind>=0)
		{
			String club=player_file.array.get(ind+2);//club of player
			checknumberOfPlayer(fileName,club);
			if(numberOfPlayers<3)
			{
				return true;
			}
		}
		return false;
	}
	public void checknumberOfPlayer(String fileName,String club) throws IOException
	{
		numberOfPlayers=0;
		File f1 = new File(fileName);
		FileReader fr = new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine())!= null)
	    {
	    	if (line.contains(club))
	    	{
	    		numberOfPlayers++;
	    	}
	    }
	    br.close();
	}
}
