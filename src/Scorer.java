package game;

import java.util.Random;

public class Scorer 
{	
	public static Result randomScore(String teamA, String teamB)
	{
		Random r = new Random();
		Result result = new Result();
		result.setup(teamA, teamB);
		result.setScore(r.nextInt(2), r.nextInt(2));
		return result;
	}
}
