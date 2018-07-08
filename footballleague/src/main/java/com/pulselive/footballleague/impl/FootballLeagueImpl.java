package com.pulselive.footballleague.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pulselive.footballlegue.FootballLeague;
import com.pulserlive.footballleague.table.LeagueTableEntry;
import com.pulserlive.footballleague.table.Match;

public class FootballLeagueImpl implements FootballLeague{

	
	private static FootballLeagueImpl instance = null;
	
	public static synchronized FootballLeagueImpl getInstance() {
		
		if(instance == null) 
			instance = new FootballLeagueImpl();
		
		return instance;
		
	}
		
	
	
	

	/**
	 * @param teamName
	 * @param match
	 * @return
	 */
	public int getGoalsFor(String teamName, Match match) {

		if (teamName.equals(match.getHomeTeam()))
			return match.getHomeScore();

		else
			return match.getAwayScore();

	}

	/**
	 * @param teamName
	 * @param match
	 * @return
	 */
	public int getGoalsAgainst(String teamName, Match match) {

		if (teamName.equals(match.getHomeTeam()))
			return match.getAwayScore();

		else
			return match.getHomeScore();

	}

	/**
	 * @param teamName
	 * @param goalsFor
	 * @param goalsAgainst
	 * @param leagueMap
	 */
	public void updateLeagueMap(String teamName, int goalsFor, int goalsAgainst,
			Map<String, LeagueTableEntry> leagueMap) {

		int played = 0;
		int won = 0;
		int drawn = 0;
		int lost = 0;
		int points = 0;
		
		int totalGoalsFor = goalsFor;
		int totalGoalsAgainst = goalsAgainst;
		

		if (leagueMap.containsKey(teamName)) {

			LeagueTableEntry leagueTableEntry = leagueMap.get(teamName);

			played = leagueTableEntry.getPlayed();
			won = leagueTableEntry.getWon();
			drawn = leagueTableEntry.getDrawn();
			lost = leagueTableEntry.getLost();
			
			totalGoalsFor += leagueTableEntry.getGoalsFor();
			totalGoalsAgainst += leagueTableEntry.getGoalsAgainst();
			points += leagueTableEntry.getPoints();
			
		}

		
		if (goalsFor > goalsAgainst) {
			won += 1;
			points += 3;
		}

		else if (goalsFor < goalsAgainst) {
			lost += 1;
		}

		else {
			drawn += 1;
			points += 1;
		}

		played++;

		LeagueTableEntry leagueTableEntry = new LeagueTableEntry(teamName, played, won, drawn, lost, totalGoalsFor,
				totalGoalsAgainst, totalGoalsFor - totalGoalsAgainst, points);

		leagueMap.put(teamName, leagueTableEntry);

	}
	
	/**
	 * @param leagueMap
	 * @return
	 */
	public List<LeagueTableEntry> getSortedLeagueTableEntryList(Map<String, LeagueTableEntry> leagueMap){
		
		List<LeagueTableEntry> sortedLeagueTableEntryList = leagueMap.values().stream()
				.sorted((obj1, obj2) -> obj1.getTeamName().compareTo(obj2.getTeamName()))
				.sorted((obj1, obj2) -> new Integer(obj2.getGoalDifference()).compareTo(obj1.getGoalDifference()))
				.sorted((obj1, obj2) -> new Integer(obj2.getPoints()).compareTo(obj1.getPoints()))			
				.collect(Collectors.toList());	
		
		return sortedLeagueTableEntryList;

	}

}
