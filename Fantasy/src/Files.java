
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

	public class Files{
		public String directory;
		public File file;
		String file_name="";
		ArrayList<String> array=new ArrayList<String>();
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> Team1=new ArrayList<String>();
		ArrayList<String> Team2=new ArrayList<String>();
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
			for(int i=0;i<array.size();i+=8)
			{
				System.out.println("Player Name : " + array.get(i) + " , " + "Nationality : " + array.get(i+1) + " , " + "Club : " + array.get(i+2)
				+ " , " + "Position : " + array.get(i+3) + " , " + "Date of Birth : " + array.get(i+4) + " , " + "Height : " + array.get(i+5)
				+ " , " + "Price : " + (Integer.parseInt(array.get(i+6))/1000000) + " million , " + "Points : " + array.get(i+7) );
				System.out.println("-------------------------------------------------------------------------------------------------" + '\n');
			}
		}
		public void writeFile(UserInfo userinfo) throws IOException
		{
				BufferedWriter out=new BufferedWriter(new FileWriter(path("Users.txt"),true));
<<<<<<< HEAD
				out.write(userinfo.getName() + "," + userinfo.getEmail() + "," + userinfo.password + "," + userinfo.getFavourite_Premier_League_Team() + "," + userinfo.getFilename() 
				+ "," +(int)userinfo.getBudget());
=======
				out.write(userinfo.getName() + "," + userinfo.getEmail() + "," + userinfo.password + "," + userinfo.getFavourite_Premier_League_Team() + "," +
				+ userinfo.getFilename() + "," + (int)userinfo.getBudget());
<<<<<<< HEAD
>>>>>>> ad566c850abb3af7ef2e8649a42fc9781dfcdc45
=======
>>>>>>> ad566c850abb3af7ef2e8649a42fc9781dfcdc45
				out.newLine();
				out.close();
		}
		public void writeFile(PlayerInfo playerinfo) throws IOException
		{
			BufferedWriter out=new BufferedWriter(new FileWriter(path("Players.txt"),true));
			out.write(playerinfo.getName() + "," + playerinfo.getNationality() + "," + playerinfo.getClub()
			+ "," + playerinfo.getPosition() + "," + playerinfo.getDate_of_Birth() + "," + playerinfo.getHeight() + " cm" + "," + playerinfo.getPrice()+ "," + playerinfo.getPoints());
			out.newLine();
			out.close();
		}
		public void ReadDG(String fileWeek) throws IOException
		{
			Team1.clear();
			Team2.clear();
			readFile(fileWeek);
			if(fileWeek.equalsIgnoreCase("Week 1.txt"))
			{
				for(int i=0;i<array.size();i+=8)
				{
					if(array.get(i+2).equalsIgnoreCase("Liverpool") && (array.get(i+3).equalsIgnoreCase("Goalkeeper") || array.get(i+3).equalsIgnoreCase("Defender")))
					{
						Team1.add(array.get(i));
					}
					else if(array.get(i+2).equalsIgnoreCase("Manchester City") && (array.get(i+3).equalsIgnoreCase("Goalkeeper") || array.get(i+3).equalsIgnoreCase("Defender")))
					{
						Team2.add(array.get(i));
					}
				}
			}
			if(fileWeek.equalsIgnoreCase("Week 2.txt"))//lsa msh 3rfen el match
			{
				for(int i=0;i<array.size();i+=8)
				{
					if(array.get(i+2).equalsIgnoreCase("Chelsea") && (array.get(i+3).equalsIgnoreCase("Goalkeeper") || array.get(i+3).equalsIgnoreCase("Defender")))
					{
						Team1.add(array.get(i));
					}
					else if(array.get(i+2).equalsIgnoreCase("Aston Villa") && (array.get(i+3).equalsIgnoreCase("Goalkeeper") || array.get(i+3).equalsIgnoreCase("Defender")))
					{
						Team2.add(array.get(i));
					}
				}
			}
		}
		public void writeFileBudget(String fileName,String playerName,String newBudgetOfUser) throws IOException
		{
			int inde=search("Users.txt",fileName);
			String line=readLinebyLine("Players.txt",playerName);
			String lineFromUserFile=null;
			lineFromUserFile=readLinebyLine(fileName,playerName);
			if(lineFromUserFile.equals("Not Found"))
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(path(fileName),true));
				out.write(line);
				out.newLine();
				out.close();
				String newLine=array.get(inde-4)+","+array.get(inde-3)+","+array.get(inde-2)+","+array.get(inde-1)+","+array.get(inde)+","+newBudgetOfUser;
				replace("Users.txt",fileName,newLine);
			}
			else
			{
				System.out.println("You already have this player in your squad.");
			}
		}
		public void readLinebyLine(String fileName) throws IOException
		{
			File file = new File(fileName);
		    FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    lines.clear();
		    while((line = br.readLine())!= null)
		    {
		        lines.add(line);
		    }
		    br.close();
		}
		public String readLinebyLine(String file,String name) throws IOException
		{
			File f1 = new File(file);
			FileReader fr = new FileReader(f1);
			@SuppressWarnings("resource")
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
			readFile(file);
			for(int i=0;i<array.size();i++)
			{
				if(array.get(i).equals(target))
				{
					return i;
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
		public void  replace(String fileName,String check,String newLine) throws IOException
	    {
			File file = new File(fileName);
		    FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    lines.clear();
		    while((line = br.readLine())!= null)
		    {
		    	if (line.contains(check))
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
