package nl.home.model;

public class ProfTeam extends Team {
	private TeamType teamType;
	private double minGoalChance = 0.12;
	private double maxGoalChance = 0.20;
	private double minPenaltyChance = 0.4;
	private double maxPenaltyChance = 0.6;
	
	public ProfTeam(String teamName) {
		super(teamName);
		this.setSponsor("their team sponsor");
		this.setSource("team budget");
		setPenaltyChance(calculateChance(this.minPenaltyChance, this.maxPenaltyChance));
		setGoalChance(calculateChance(this.minGoalChance, this.maxGoalChance));
		setTeamType(TeamType.PROFESSIONAL);
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
