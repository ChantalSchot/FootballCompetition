package nl.home.model;

public class Match {
	boolean penaltiesFinished;
	
	public Team playMatch(Team a, Team b) {
		System.out.println("\nMatch between " + a.getTeamName() + " and " + b.getTeamName() + " is starting now!");
		int scoreA = 0;
		int scoreB = 0;
		penaltiesFinished = false;
		
		// Play 9 matches in a row.
		for (int i = 0; i < 9; i++) {
			// Increase score when scoreGoal returns true (if random number is within goal score chance of the team).
			if (scoreGoal(a.getGoalChance())) {
				scoreA++;
			}
			if (scoreGoal(b.getGoalChance())) {
				scoreB++;
			};
			System.out.println(((i+1)*10) + "' " + a.getTeamName() + " " + scoreA + " : " + scoreB + " " + b.getTeamName());
		}
		
		return getWinner(a, b, scoreA, scoreB);
	}
	
	public Team getWinner(Team a, Team b, int scoreA, int scoreB) {
		System.out.print("Final standings: " + a.getTeamName() + " " + scoreA + " : " + scoreB + " " + b.getTeamName());
		// Check which team has highest score and return winning team.
		if (scoreA < scoreB) {
			System.out.println(". The " + b.getTeamName() + " win!\n");
			return b;
		} else if (scoreA > scoreB) {
			System.out.println(". The " + a.getTeamName() + " win!\n");
			return a;
		} else if (!penaltiesFinished) {
			// For equal standings, penalties must be played.
			System.out.println(". Equal standings, time for penalties... ");
			return playPenalty(a,b);
		} else {
			// Play penalty shootout when penalty standings are equal.
			System.out.println(". Equal standings, penalty shootout... ");
			return penaltyShootOut(a,b,scoreA,scoreB);
		}
		
	}
	
	public Team playPenalty(Team a, Team b) {
		int penaltyA = 0;
		int penaltyB = 0;
		for (int i = 0; i < 5; i++) {
			// Play 5 rounds of penalties.
			// Increase score when scorePenalty returns true (if random number is within penalty score chance of the team).
			if (scorePenalty(a.getPenaltyChance())) {
				penaltyA++;
			}
			if (scorePenalty(b.getPenaltyChance())) {
				penaltyB++;
			}
			System.out.println("Penalty round " + (i+1) + ". " + a.getTeamName() + " " + penaltyA + " : " + penaltyB + " " + b.getTeamName());
		}
		penaltiesFinished = true;
		return getWinner(a, b, penaltyA, penaltyB);
	}
	
	
	public Team penaltyShootOut(Team a, Team b, int penaltyA, int penaltyB) {
		int i = 6;
		// Starting at round 6, penalties will be played as long as penalty score remains equal.
		do {
			if (scorePenalty(a.getPenaltyChance())) {
				penaltyA++;
			}
			if (scorePenalty(b.getPenaltyChance())) {
				penaltyB++;
			}
			System.out.println("Penalty round " + i++ + ". " + a.getTeamName() + " " + penaltyA + " : " + penaltyB + " " + b.getTeamName());
		}
		while (penaltyA == penaltyB);
		return getWinner(a, b, penaltyA, penaltyB);
	}
	
	//Goal will be scored (return true) if random number is within team's range of chance to score a goal.
	public boolean scoreGoal(double goalChance) {
		if (Math.random() <= goalChance) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Penalty will be scored (return true) if random number is within team's range of chance to score a penalty.
	public boolean scorePenalty(double penaltyChance) {
		if (Math.random() <= penaltyChance) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
