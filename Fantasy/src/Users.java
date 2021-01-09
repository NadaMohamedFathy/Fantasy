
import java.io.IOException;

public class Users extends Observers
{

	private Events event;
	public Users(Events event) {
		this.event = event;
		this.event.register(this);
	}
	public void Update(String name,String file,int point) throws IOException
	{
		int ind=-1;
		update_file.readFile("Users.txt");
		int size=update_file.array.size();
		for(int i=0;i<size;i+=6)
		{
			update_file.readFile("Users.txt");
			String fileName=update_file.array.get(i) + ".txt";
			ind=update_file.search(fileName,name);//index bta3 el player w mnha el points bta3o hykon ind+7
			if(ind>=0)
			{
				String playerName=update_file.array.get(ind);
				String points=update_file.array.get(ind+7);
				int Point=Integer.parseInt(points);
				if(Point==0 && point<0)
				{
					Point=0;
				}
				else
				{
					Point+=point;
				}
				String newpoints=String.valueOf(Point);
				String newLine=update_file.array.get(ind) + "," + update_file.array.get(ind+1) + "," + update_file.array.get(ind+2) 
				+ "," + update_file.array.get(ind+3) + "," + update_file.array.get(ind+4)+ ","
						+ update_file.array.get(ind+5) + "," + update_file.array.get(ind+6) + "," + newpoints;
					String lineFromWeekFile=null;
					lineFromWeekFile=update_file.readLinebyLine(fileName,playerName);
					if(lineFromWeekFile.equals("Not Found"))
					{
						continue;
					}
					else
					{
						update_file.replace(fileName,playerName,newLine);
					}
			}
		}
	}
	public void unSubscribe() {
		this.event.remove(this);
	}
}
