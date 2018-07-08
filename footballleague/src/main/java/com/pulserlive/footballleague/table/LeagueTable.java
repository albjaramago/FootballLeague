package com.pulserlive.footballleague.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pulselive.footballleague.exception.ExceptionMessage;
import com.pulselive.footballleague.exception.LeagueException;
import com.pulselive.footballleague.impl.FootballLeagueImpl;
import com.pulselive.footballlegue.FootballLeague;



public class LeagueTable {

	private List<Match> matches;
	
	private FootballLeague footballLeague = FootballLeagueImpl.getInstance();
	
	

	public LeagueTable(final List<Match> matches) {
		super();
		this.matches = matches;
	}

	/**
	 * Get the ordered list of league table entries for this league table.
	 *
	 * @return
	 */
	public List<LeagueTableEntry> getTableEntries() {
	
		Map<String, LeagueTableEntry> leagueMap = new HashMap<String, LeagueTableEntry>();

		
		matches.forEach(match -> {
			
			if(match.getHomeTeam()== null)
				throw new LeagueException(ExceptionMessage.HOME_TEAM_NAME_ERROR.getValue());
			
			if(match.getAwayTeam()== null)
					throw new LeagueException(ExceptionMessage.AWAY_TEAM_NAME_ERROR.getValue());

			//Update for HomeTeam on leagueMap
			footballLeague.updateLeagueMap(match.getHomeTeam(), footballLeague.getGoalsFor(match.getHomeTeam(), match),
					footballLeague.getGoalsAgainst(match.getHomeTeam(), match), leagueMap);

			//Update AwayTeam on leagueMap
			footballLeague.updateLeagueMap(match.getAwayTeam(), footballLeague.getGoalsFor(match.getAwayTeam(), match),
					footballLeague.getGoalsAgainst(match.getAwayTeam(), match), leagueMap);

		});
		
		return footballLeague.getSortedLeagueTableEntryList(leagueMap);
	}
	
	


}
