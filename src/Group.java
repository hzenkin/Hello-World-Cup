package game;

import java.util.HashMap;
import java.util.Map;

public class Group 
{
	Result finalResults[]; 
	Map<Integer, String> countryTable;
	Map<String, Integer> pointsTable;

	public Group() 
	{
		finalResults = new Result[6]; 
		countryTable = new HashMap<>();
		pointsTable  = new HashMap<>();

		String list[] = 
		{	"Popular Country",  
			"Populus Country", 
			"Polar Country", 	
			"Pony County"	
		};
		// Developer Warning: DO NOT USE initials for 
		// this group, use full names instead,

		int index=0;
		for(String name: list)
		{
			index++;
			countryTable.put(index, name);
			pointsTable.put(name, 0);
		}
	}
	
	public void playAllGamesAtOnce()
	{
		int teamA[] = { 1, 2, 3, 4, 1, 2};
		int teamB[] = { 2, 3, 4, 1, 3, 4};
		
		for(int n=0; n<6; n++)
			finalResults[n] = 
			Scorer.randomScore(countryTable.get(teamA[n]), countryTable.get(teamB[n]));
	}
	
	public void processResults()
	{
		int currentPoints;
		
		for(Result res : finalResults)
		{
			if(res.isDraw())
			{
				currentPoints = pointsTable.get(res.teamA) + 1;
				pointsTable.put(res.teamA, currentPoints);
				
				currentPoints = pointsTable.get(res.teamB) + 1;
				pointsTable.put(res.teamB, currentPoints);
			}
			else
			{
				currentPoints = pointsTable.get(res.getWinner()) + 3;
				pointsTable.put(res.getWinner(), currentPoints);
			}
		}
	}
	
	public int[] groupOutcome()
	{
		int out[] = new int[4];
		
		for(int n=0; n<4; n++)
			out[n] = pointsTable.get(countryTable.get(n+1));
		
		return out;
	}
	
}
