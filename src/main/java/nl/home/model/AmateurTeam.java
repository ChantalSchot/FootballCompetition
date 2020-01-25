package nl.home.model;

public class AmateurTeam extends Team {
	private TeamType teamType;
	private double minGoalChance = 0.08;
	private double maxGoalChance = 0.18;
	private double minPenaltyChance = 0.3;
	private double maxPenaltyChance = 0.5;
	
	public AmateurTeam(String teamName) {
		super(teamName);
		this.setSponsor("drinking mascotte");
		this.setSource("base pub");
		setPenaltyChance(calculateChance(this.minPenaltyChance, this.maxPenaltyChance));
		setGoalChance(calculateChance(this.minGoalChance, this.maxGoalChance));
		setTeamType(TeamType.AMATEUR);
	}
	
	public double getMinGoalChance() {
		return minGoalChance;
	}
	
	public double getMaxGoalChance() {
		return maxGoalChance;
	}
	
	public double getMinPenaltyChance() {
		return minPenaltyChance;
	}
	
	public double getMaxPenaltyChance() {
		return maxPenaltyChance;
	}
}
