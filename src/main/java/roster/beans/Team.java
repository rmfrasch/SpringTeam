package roster.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Team {

	@Column(name="team_name")
	private String teamName;
	@Column(name="player_number")
	private int playerNum;

	public Team(String teamName) {
		super();
		this.teamName = teamName;
	}
	public Team(String teamName, int playerNum) {
		super();
		this.teamName = teamName;
		this.playerNum = playerNum;
	}
	
	//no-arg constructor
	public Team() {
		
	}


	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	@Override
	public String toString() {
		return "Team: " + ", teamName=" + teamName + ", playerNum=" + playerNum + "]";
	}
	
	
}
