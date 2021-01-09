import java.io.IOException;
import java.util.ArrayList;

public class ForPlayingUpTo60MinutesOrMore extends Events
{

	private ArrayList<Observers> observer=new ArrayList<Observers>();
	private int point;
	private String file;
	private String name;
	public void applayEvent(String playerName,String fileWeek) throws Exception
	{
		point=2;
		file=fileWeek;
		name=playerName;
		this.notifyObservers();
	}
	
	public void register(Observers o) {
		this.observer.add(o);
	}
 
	public void remove(Observers o) {
		if (!observer.isEmpty()) {
			observer.remove(o);
		}
	}
 
	public void notifyObservers()
	{
		for (Observers o : observer) 
		{
			try {
				o.Update(name,file,point);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
