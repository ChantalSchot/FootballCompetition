package nl.home.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmateurTeamTest {
	AmateurTeam amateurTeam;
	
	@org.junit.jupiter.api.Test
	
	@BeforeEach
	void init() {
		amateurTeam = new AmateurTeam("TestTeam");
	}
	
	@org.junit.jupiter.api.Test
	void calculateGoalChance() {
		for (int i = 0; i < 10; i++) {
			amateurTeam = new AmateurTeam("TestTeam");
			System.out.println(amateurTeam.getGoalChance());
		}
		assertTrue((amateurTeam.getGoalChance() <= amateurTeam.getMaxGoalChance()) && (amateurTeam.getGoalChance() >= amateurTeam.getMinGoalChance()));
	}
	
	@Test
	void calculatePenaltyChance() {
		for (int i = 0; i < 10; i++) {
			amateurTeam = new AmateurTeam("TestTeam");
			System.out.println(amateurTeam.getPenaltyChance());
		}
		assertTrue((amateurTeam.getPenaltyChance() <= amateurTeam.getMaxPenaltyChance()) && (amateurTeam.getPenaltyChance() >= amateurTeam.getMinPenaltyChance()));
		
	}
}