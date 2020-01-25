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
	
	public void setMinGoalChance(double minGoalChance) {
		this.minGoalChance = minGoalChance;
	}
	
	public double getMaxGoalChance() {
		return maxGoalChance;
	}
	
	public void setMaxGoalChance(double maxGoalChance) {
		this.maxGoalChance = maxGoalChance;
	}
	
	public double getMinPenaltyChance() {
		return minPenaltyChance;
	}
	
	public void setMinPenaltyChance(double minPenaltyChance) {
		this.minPenaltyChance = minPenaltyChance;
	}
	
	public double getMaxPenaltyChance() {
		return maxPenaltyChance;
	}
	
	public void setMaxPenaltyChance(double maxPenaltyChance) {
		this.maxPenaltyChance = maxPenaltyChance;
	}
}
