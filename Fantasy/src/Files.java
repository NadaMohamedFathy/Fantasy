
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

	public class Files{
		public String directory;
		public File file;
		String file_name="";
		int numberOfPlayers=0;
		int numberOfGoalkeepers=0;
		int numberOfForwards=0;
		int numberOfMidfielders=0;
		int numberOfDefenders=0;
		int numberOfPlayersInFile=0;
		ArrayList<String> array=new ArrayList<String>();
		ArrayList<String> lines = new ArrayList<String>();
		public Files() 
		{
			directory = System.getProperty("user.dir");
			file=new File(directory);
		}
		public File path(String file_name) 
		{
			file = new File(file_name);
			directory=""+file.getAbsoluteFile();
			return file;
		}
		public void readFile(String fileName) throws IOException
		{
			array.clear();
			File f;
			f=path(fileName);
			if(f.exists())
			{
				FileReader fileReader = new FileReader(f);
		        BufferedReader in = new BufferedReader(fileReader);
		        String line;
		        String section="";
		        while((line = in.readLine())!= null)
		        {
		        	for(int i=0;i<line.length();i++)
		    		{
		    			if(line.charAt(i)!=',' && i<line.length()-1)
		    				section+=line.charAt(i);
		    			else if(i==line.length()-1)
		    			{
		    				section+=line.charAt(i);
		    				array.add(section);
		    				section="";
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
		public void displayFile(String fileName) throws IOException
		{
			readFile(fileName);
			for(int i=0;i<array.size();i+=12)
			{
				System.out.println("Player Name : " + array.get(i) + " , " + "Nationality : " + array.get(i+1) + " , " + "Club : " + array.get(i+2)
				+ " , " + "Position : " + array.get(i+3) + " , " + "Date of Birth : " + array.get(i+4) + " , " + "Height : " + array.get(i+5)
				+ " , " + "Price : " + (Integer.parseInt(array.get(i+6))/1000000) + " million , " + "Appearances : " + array.get(i+7) +" , " + "Goals : " + array.get(i+8) +" , " + "Wins : " 
				+ array.get(i+9) +" , " + "Losses : " + array.get(i+10) +" , " + "CleanSheets : " + array.get(i+11));
			}
		}
		public void writeFile(UserInfo userinfo) throws IOException
		{
				BufferedWriter out=new BufferedWriter(new FileWriter(path("Users.txt"),true));
				out.write(userinfo.getName() + "," + userinfo.getEmail() + "," + userinfo.password + "," + userinfo.getFavourite_Premier_League_Team() + "," +
				+ userinfo.getFilename() + "," + (int)userinfo.getBudget());
				out.newLine();
				out.close();
		}
		public void writeFile(PlayerInfo playerinfo) throws IOException
		{
			BufferedWriter out=new BufferedWriter(new FileWriter(path("Players.txt"),true));
			out.write(playerinfo.getName() + "," + playerinfo.getNationality() + "," + playerinfo.getClub()
			+ "," + playerinfo.getPosition() + "," + playerinfo.getDate_of_Birth() + "," + playerinfo.getHeight() + " cm" + "," + playerinfo.getPrice()
			 + "," + playerinfo.getAppearances() + "," + playerinfo.getGoals() + "," + playerinfo.getWins() + "," + playerinfo.getLosses()+ "," + playerinfo.getCleanSheets());
			out.newLine();
			out.close();
		}
		public int checkNOPinSquad(String fileName) throws IOException
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
		    return numberOfPlayersInFile;
		}
		public void checknumberOfPlayers(String fileName,String club) throws IOException
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
		public void checkPosition(String fileName,String position) throws IOException
		{
			numberOfGoalkeepers=0;
		    numberOfForwards=0;
			numberOfMidfielders=0;
			numberOfDefenders=0;
		    numberOfPlayersInFile=0;
			File f1 = new File(fileName);
			FileReader fr = new FileReader(f1);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    if(position.equals("Goalkeeper"))
		    {
		    	while((line = br.readLine())!= null)
			    {
			    	if (line.contains(position))
			    	{
			    		numberOfGoalkeepers++;
			    	}
			    }
			    br.close();
		    }
		    else if(position.equals("Forward"))
		    {
		    	while((line = br.readLine())!= null)
			    {
			    	if (line.contains(position))
			    	{
			    		numberOfForwards++;
			    	}
			    }
			    br.close();
		    }
		    else if(position.equals("Midfielder"))
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
		    else if(position.equals("Defender"))
		    {
		    	while((line = br.readLine())!= null)
			    {
			    	if (line.contains(position))
			    	{
			    		numberOfDefenders++;
			    	}
			    }
			    br.close();
		    }
		}
		public void writeFile(String fileName,String playerName,double budgetOfUser,double priceOfPlayer,int inde) throws IOException
		{
			String line=readLinebyLine("Players.txt",playerName);
			String lineFromUserFile=null;
			lineFromUserFile=readLinebyLine(fileName,playerName);
			if(lineFromUserFile.equals("Not Found"))
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(path(fileName),true));
				out.write(line);
				out.newLine();
				out.close();
				double newBudget=budgetOfUser-priceOfPlayer;
				String newBudgetOfUser=String.format("%f",newBudget);
				String newLine=array.get(inde-4)+","+array.get(inde-3)+","+array.get(inde-2)+","+array.get(inde-1)+","+array.get(inde)+","+newBudgetOfUser;
				replace(fileName,newLine);
			}
			else
			{
				System.out.println("You already have this player in your squad.");
			}
		}
		public String readLinebyLine(String file,String name) throws IOException
		{
			File f1 = new File(file);
			FileReader fr = new FileReader(f1);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    while((line = br.readLine())!= null)
		    {
		    	if (line.contains(name))
		    	{
		    		return line;
		    	}
		    }
		    br.close();
			return "Not Found";
		}
		public int search(String file,String target) throws IOException
		{
			if(file.equals("Players.txt"))
			{
				readFile(file);
				for(int i=0;i<array.size();i++)
				{
					if(array.get(i).equals(target))
					{
						return i;
					}
				}
			}
			else if(file.equals("Users.txt"))
			{
				readFile(file);
				for(int i=0;i<array.size();i++)
				{
					if(array.get(i).equals(target))
					{
						return i;
					}
				}
			}
			return -1;
		}
		public boolean check(String element) throws IOException
		{
			readFile("Users.txt");
		    if(array.contains(element))
	        {
				return true;
	        }
			return false;
		}
		public int check(String element1,String element2) throws IOException
		{
			readFile("Users.txt");
			for(int i=0;i<array.size();i++)
	    	{
				if(array.get(i).equals(element1))
	        	{
					if(array.get(i+1).equals(element2))
				    {
						return i;
				    }	
	        	}
	    	}
			return -1;
			
		}
		public String UserFile(int index) throws IOException
		{
			readFile("Users.txt");
			return array.get(index+3);
		}
		public void  replace(String fileName,String newLine) throws IOException
	    {
			File file = new File("Users.txt");
		    FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    lines.clear();
		    while((line = br.readLine())!= null)
		    {
		    	if (line.contains(fileName))
		    	{
		    		line = line.replace(line, newLine);
		    	}
		        lines.add(line);
		    }
		    PrintWriter writer = new PrintWriter(file);
		    writer.print(lines.get(0));
		    writer.close();
			BufferedWriter out=new BufferedWriter(new FileWriter(file,true));
			for(int i=1;i<lines.size();i++)
			{
				out.newLine();
			    out.write(lines.get(i));
			}
			br.close();
			out.close();
	    }
	}
