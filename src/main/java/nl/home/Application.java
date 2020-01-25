package nl.home;

import nl.home.model.AmateurTeam;
import nl.home.model.Competition;
import nl.home.model.ProfTeam;

public class Application {
	public static void main(String[] args) {
		Competition competition = new Competition();
		
		competition.teams.add(new AmateurTeam("Lemurs"));
		competition.teams.add(new AmateurTeam("Hedgehogs"));
		competition.teams.add(new AmateurTeam("Guinea Pigs"));
		competition.teams.add(new AmateurTeam("Warthogs"));
		competition.teams.add(new AmateurTeam("Monkeys"));
		competition.teams.add(new AmateurTeam("Dolphins"));
		competition.teams.add(new AmateurTeam("Rabbits"));
		competition.teams.add(new AmateurTeam("Badgers"));
		competition.teams.add(new ProfTeam("Sharks"));
		competition.teams.add(new ProfTeam("Tigers"));
		competition.teams.add(new ProfTeam("Killer Whales"));
		competition.teams.add(new ProfTeam("Elephants"));
		competition.teams.add(new ProfTeam("Grizzly Bears"));
		competition.teams.add(new ProfTeam("Tigers"));
		competition.teams.add(new ProfTeam("Rhinos"));
		competition.teams.add(new ProfTeam("Eagles"));
		
		competition.playCompetition(competition.teams);
		
	}
}
