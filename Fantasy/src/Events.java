

public abstract class  Events {
	
	
	public void applayEvent(String playerName,String fileWeek) throws Exception
	{
		
	}
	public abstract void register(Observers o);
	 
	public abstract void remove(Observers o);
 
	public abstract void notifyObservers();
}