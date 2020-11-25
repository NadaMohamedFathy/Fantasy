import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Files{
	public String directory;
	public File file;
	String file_name="";
	public String name = "";
	public String email= "";
	public String password= "";
	public String favourite_premier_league_team= "";
	ArrayList<String> array=new ArrayList<String>();
	public Files() 
	{
		directory = System.getProperty("user.dir");
		file=new File(directory);
	}
	public File user_path(String file_name) 
	{
		file = new File(file_name);
		directory=""+file.getAbsoluteFile();
		return file;
	}
	public void readFile(File file) throws IOException
	{
		if(file.exists())
		{
			FileReader fileReader = new FileReader(file);
	        BufferedReader in = new BufferedReader(fileReader);
	        String line;
	        String section="";
	        while((line = in.readLine())!= null)
	        {
	        	for(int i=0;i<line.length();i++)
	    		{
	    			if(line.charAt(i)!=' ' && i<line.length()-1)
	    				section+=line.charAt(i);
	    			else if(i==line.length()-1)
	    			{
	    				section+=line.charAt(i);
	    				array.add(section);
	    			}
	    			else
	    			{
	    				array.add(section);
	    				section="";
	    			}
	    		}
	        }
	        	in.close();
	}
	}
	public void writeFile(File file) throws IOException
	{
		BufferedWriter out=new BufferedWriter(new FileWriter(user_path("Users.txt"),true));
		out.write(name + " " + email + " " + password + " " + favourite_premier_league_team);
		out.newLine();
		out.close();
	}
	public boolean check(String element) throws IOException
	{
		readFile(user_path("Users.txt"));
	    if(array.contains(element))
        {
			return true;
        }
		return false;
	}
	public boolean check(String element1,String element2) throws IOException
	{
		readFile(user_path("Users.txt"));
		for(int i=0;i<array.size();i++)
    	{
			if(array.get(i).equals(element1))
        	{
				if(array.get(i+1).equals(element2))
			    {
					return true;
			    }	
        	}
    	}
		return false;
		
	}
}
