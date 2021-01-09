
import java.io.IOException;

public class Week extends Observers
{

	private Events event;
	public Week(Events event) {
		this.event = event;
		this.event.register(this);
	}
	public void Update(String name,String file,int point) throws IOException
	{
		int inde=-1;
		inde=update_file.search(file,name);//index bta3 el player w mnha el points bta3o hykon ind+1
		if(inde>=0)
		{
			String player_points=update_file.array.get(inde+7);
			int poin=Integer.parseInt(player_points);
			if(poin==0 && point<0)
			{
				poin=0;
			}
			else
			{
				poin+=point;
			}
			String Line=update_file.array.get(inde) + "," + update_file.array.get(inde+1) + "," + update_file.array.get(inde+2) 
			+ "," + update_file.array.get(inde+3) + "," + update_file.array.get(inde+4)+ "," + update_file.array.get(inde+5) + 
			"," + update_file.array.get(inde+6) + "," + poin;
			String lineFromWeekFile=null;
			lineFromWeekFile=update_file.readLinebyLine(file,name);
			boolean check=lineFromWeekFile.equals("Not Found");
			if(check==false)
			{
				update_file.replace(file,name,Line);
			}
		}
	}
	public void unSubscribe() {
		this.event.remove(this);
	}
}
