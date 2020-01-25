package nl.home.model;

public abstract class Team {
	private double teamId;
	private String teamName;
	private String sponsor;
	private String source;
	private TeamType teamType;
	private double goalChance;
	private double penaltyChance;
	
	@Override
	public String toString() {
		return "TeamId: " + (Math.floor(this.teamId * 100)) / 100 + ", team " + this.teamName + " (" + this.teamType.toString().toLowerCase() + "s), "
					   + "sponsored by " + this.sponsor + ", party source: " + this.source + ". ("
					   + (int)Math.floor(this.goalChance * 100) + "% goal chance, "+ (int)Math.floor(this.penaltyChance * 100) + "% penalty chance).";
	}
	
	public Team(String teamName) {
		this.teamName = teamName;
		this.teamId = setNewTeamId();
	}
	
	public void setGoalChance(double goalChance) {
		this.goalChance = goalChance;
	}
	
	public void setPenaltyChance(double penaltyChance) {
		this.penaltyChance = penaltyChance;
	}
	
	public double getGoalChance() {
		return goalChance;
	}
	
	public double getPenaltyChance() {
		return penaltyChance;
	}
	
	public double setNewTeamId() {
		return Math.random();
	}
	
	public void setTeamType(TeamType teamType) {
		this.teamType = teamType;
	}
	
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public double getTeamId() {
		return teamId;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public String getSponsor() {
		return sponsor;
	}
	
	public String getSource() {
		return source;
	}
	
	public TeamType getTeamType() {
		return teamType;
	}
	
	public double calculateChance(double minChance, double maxChance) {
		return (Math.random() * (maxChance - minChance)) + minChance;
	}
}
