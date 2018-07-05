package game;

public class Result 
{
	public String teamA, teamB;
	public int goalsA, goalsB;

	public Result() 
	{
		teamA = "To Be Set";
		teamB = "To Be Set";
		goalsA = -1;
		goalsB = -1;
	}
	
	public void setup(String tA, String tB)
	{
		teamA = tA;
		teamB = tB;
		goalsA = 0;
		goalsB = 0;
	}

	public void setScore(int scoreA, int scoreB) 
	{
		goalsA = scoreA;
		goalsB = scoreB;
	}
	
	public boolean isDraw()
	{
		return goalsA==goalsB;
	}
	
	public String getWinner()
	{
		if(goalsA==goalsB)
			return "No Winners or Losers for this game";
		if(goalsA<goalsB)
			return teamB;
		return teamA;
	}
	
	@Override
	public String toString()
	{
		return teamA + "=" + goalsA + " / " + teamB + "=" + goalsB + " ; " ;
	}
}
