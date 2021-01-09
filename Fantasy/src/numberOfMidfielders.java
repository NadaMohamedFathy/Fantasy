import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class numberOfMidfielders extends SquadRules
{

	static int numberOfMidfielders=0;
	public boolean applayRules(String fileName,String playerName) throws Exception
	{
		int ind=-1;
		ind=indexSearch(playerName);//index bta3 el player w mnha el club bta3o hykon ind+2 w el position bta3o ind+3
		if(ind>=0)
		{
			String position=player_file.array.get(ind+3);//position of player
			checkPosition(fileName,position);
			if(numberOfMidfielders<5)
			{
				return true;
			}
		}
		return false;
	}
	public void checkPosition(String fileName,String position) throws IOException
	{
		numberOfMidfielders=0;
		File f1 = new File(fileName);
		FileReader fr = new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    if(position.equals("Midfielder"))
	    {
	    	while((line = br.readLine())!= null)
		    {
		    	if (line.contains(position))
		    	{
		    		numberOfMidfielders++;
		    	}
		    }
		    br.close();
	    }
	}
}
