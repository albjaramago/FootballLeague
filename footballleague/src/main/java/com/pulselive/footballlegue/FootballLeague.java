package com.pulselive.footballlegue;

import java.util.List;
import java.util.Map;

import com.pulserlive.footballleague.table.LeagueTableEntry;
import com.pulserlive.footballleague.table.Match;

public interface FootballLeague {

	
	/**
	 * @param teamName
	 * @param match
	 * @return
	 */
	public int getGoalsFor(String teamName, Match match);

	/**
	 * @param teamName
	 * @param match
	 * @return
	 */
	public int getGoalsAgainst(String teamName, Match match);

	/**
	 * @param teamName
	 * @param goalsFor
	 * @param goalsAgainst
	 * @param leagueMap
	 */
	public void updateLeagueMap(String teamName, int goalsFor, int goalsAgainst,
			Map<String, LeagueTableEntry> leagueMap);
	
	
	
	/**
	 * @param leagueMap
	 * @return
	 */
	public List<LeagueTableEntry> getSortedLeagueTableEntryList(Map<String, LeagueTableEntry> leagueMap);
	
}
