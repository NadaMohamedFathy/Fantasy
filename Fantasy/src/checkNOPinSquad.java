import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class checkNOPinSquad extends SquadRules
{

	static int numberOfPlayersInFile=0;
	public boolean applayRules(String fileName,String playerName)throws Exception
	{
		CheckNOPinSquad(fileName);
		if(numberOfPlayersInFile<15)
		{
			return true;
		}
		return false;
	}
	public void CheckNOPinSquad(String fileName) throws IOException
	{
		numberOfPlayersInFile=0;
		File f1 = new File(fileName);
		FileReader fr = new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine())!= null)
	    {
	    	numberOfPlayersInFile++;
	    }
	    br.close();
	}
}
