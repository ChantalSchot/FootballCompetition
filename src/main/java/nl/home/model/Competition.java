package nl.home.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Competition {
	Match match;
	public List<Team> teams;
	
	public Competition() {
		teams = new ArrayList<Team>();
		match = new Match();
	}
	
	public void playCompetition(List<Team> competitionList) {
		// Competition is only possible with even number of teams that has to be a multiple of 8.
		
		// Sort teams based on random ID number first
		sortTeams(competitionList);
		// Print all participating teams
		printTeams(competitionList);
		
		// Keep starting new rounds until 1 team is left
		do {
			if (competitionList.toArray().length == 4) {
				System.out.println("Four teams left. Time for the SEMI FINALS...");
			}
			if (competitionList.toArray().length == 2) {
				System.out.println("Only two teams left. Time for the FINAL MATCH!");
			}
			// Competition round will start with current list of teams
			competitionRound(competitionList);
		} while (competitionList.toArray().length > 1);
		
		Team winningTeam = competitionList.get(0);
		System.out.println("The competition is over. The " + winningTeam.getTeamName().toUpperCase() + " HAVE WON! \nThey will be celebrating with their "
								   + winningTeam.getSponsor() + ", a party providing by their " + winningTeam.getSource() + "!!!");
	}
	
	public List<Team> competitionRound(List<Team> competitionList) {
		Team[] teamArray = competitionList.toArray(new Team[competitionList.size()]);
		// Empty current competition list to add only winning teams
		competitionList.clear();
		
		// Print statement of new round while >4 teams are left
		if (teamArray.length > 4) {
			System.out.println(teamArray.length + " teams left. New round starting...");
		}
		
		// Play number of matches equal to half the number of teams
		for (int i = 0; i < (teamArray.length / 2); i++) {
			// Matches are between teams with half the list length in between,
			// e.g. team 1 vs team 5, team 2 vs team 6, team 3 vs team 7 etc
			Team tempTeamA = teamArray[i];
			Team tempTeamB = teamArray[i + (teamArray.length / 2)];
			// add winning teams back to the competition list
			competitionList.add(match.playMatch(tempTeamA,tempTeamB));
		}
		// Return competition list with winning teams from current round
		return competitionList;
	}
	
	// Print list of team details per team
	public void printTeams(List<Team> teamList) {
		for (Team team : teamList) {
			System.out.println(team.toString());
		}
	}
	
	// Sort teams numerically by teamId
	public List<Team> sortTeams(List<Team> teamList) {
		teamList.sort(Comparator.comparingDouble(Team::getTeamId));
		return teamList;
	}
}
