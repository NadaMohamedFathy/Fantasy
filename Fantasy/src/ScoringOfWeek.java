import java.io.IOException;

public class ScoringOfWeek {

	Files score_file=new Files();
	public int Score(int index,String file_week) throws IOException
	{
		int score=0;
		if(index>=0)
		{
			String userfile=score_file.UserFile(index);
			score_file.readFile(file_week);
			score_file.readLinebyLine(userfile);
			for(int i=0;i<score_file.array.size();i+=8)
			{
				int points=Integer.parseInt(score_file.array.get(i+7));
				for(int j=0;j<score_file.lines.size();j++)
				{
					if(score_file.lines.get(j).contains(score_file.array.get(i)))
					{
						score+=points;
					}
				}
			}
		}	
		return score;
	}
}
