package com.pulselive.footballleague;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pulserlive.footballleague.table.LeagueTable;
import com.pulserlive.footballleague.table.LeagueTableEntry;
import com.pulserlive.footballleague.table.Match;

/**
 * Unit tests
 */
public class LeagueTableTest{

	private List<Match> matchesList;
	
	
	
	@Test
	public void leagueTableTestList() {
		
		LeagueTable leagueTable = new LeagueTable(matchesList);
		 
		List<LeagueTableEntry> sortedLeagueTableEntryList = leagueTable.getTableEntries();
		
		assertTrue(!sortedLeagueTableEntryList.isEmpty());
		
		sortedLeagueTableEntryList.forEach(leagueTableEntry -> System.out.println(leagueTableEntry));

		
	}
	

	
	@Test
	public void leagueTableTestWon() {
		
		 
		LeagueTable leagueTable = new LeagueTable(matchesList);
		
		List<LeagueTableEntry> leagueTableList = leagueTable.getTableEntries();
		
		leagueTableList.forEach(item ->{
			assertTrue(item.getPlayed() == (item.getWon()+ item.getLost() + item.getDrawn()));
		});
		
		


	}
	
	
	@Test
	public void leagueTableTestGoals() {
		
		LeagueTable leagueTable = new LeagueTable(matchesList);
	
		List<LeagueTableEntry> leagueTableList = leagueTable.getTableEntries();
		
		leagueTableList.forEach(item ->{
			assertTrue(item.getGoalDifference() == (item.getGoalsFor()-item.getGoalsAgainst()));
			});
		
	}
	
	
	@Test
	public void leagueTableTestPoints() {
	
		LeagueTable leagueTable = new LeagueTable(matchesList);
		
		List<LeagueTableEntry> leagueTableList = leagueTable.getTableEntries();
		
		leagueTableList.forEach(item ->{
			assertTrue(item.getPoints() == (item.getWon()*3 + item.getDrawn()));
			});
		
		
	}
	
	
	@Test
	public void leagueTableTestSortedList() {

		Match match01 = new Match("Arsenal", "West Ham", 3, 0);
		Match match02 = new Match("Burnley", "West Ham", 2, 0);
		Match match03 = new Match("Everton", "West Ham", 1, 0);

		List<Match> matchesList = new ArrayList<>();

		matchesList.add(match01);
		matchesList.add(match02);
		matchesList.add(match03);

		LeagueTable leagueTable = new LeagueTable(matchesList);

		List<LeagueTableEntry> leagueTableList = leagueTable.getTableEntries();

		leagueTableList.forEach(item -> {

			if ((leagueTableList.indexOf(item) + 1) < leagueTableList.size()) {
				assertTrue(item.getPoints() >= leagueTableList.get(leagueTableList.indexOf(item) + 1).getPoints());
				assertTrue(item.getGoalDifference() >= leagueTableList.get(leagueTableList.indexOf(item) + 1)
						.getGoalDifference());
				assertTrue(item.getGoalsFor() >= leagueTableList.get(leagueTableList.indexOf(item) + 1).getGoalsFor());
				assertTrue(item.getTeamName().compareTo(leagueTableList.get(leagueTableList.indexOf(item) + 1).getTeamName())<0);
			}

		});			

		
	}
	


	
	@Before
	public void getMatchesList(){
		 
		
		Match match01 = new Match("Arsenal", "Everton", 3, 1);
		Match match02 = new Match("Everton", "Arsenal", 3, 2);
		Match match03 = new Match("Burnley", "West Ham", 1, 2);
		Match match04 = new Match("West Ham", "Burnley", 2, 2);
		Match match05 = new Match("Chelsea", "Sunderland", 5, 1);
		Match match06 = new Match("Chelsea", "Tottenham", 1, 0);
		Match match07 = new Match("Hull City", "Tottenham", 1, 7);
		Match match08 = new Match("Leicester", "Bournemouth", 1, 1);
		
		List<Match> matchesList = new ArrayList<>();
		
		matchesList.add(match01);
		matchesList.add(match02);
		matchesList.add(match03);
		matchesList.add(match04);
		matchesList.add(match05);
		matchesList.add(match06);
		matchesList.add(match07);
		matchesList.add(match08);
		
		
		this.matchesList = matchesList;
	
	
	}
	

}
