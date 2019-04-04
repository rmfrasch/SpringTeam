package roster.beans;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="win_ratio")
	private float winRatio;
	
	
	public Player(long id, String firstName, String lastName, float winRatio) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.winRatio = winRatio;
	
	}


	
	//no arg contructor.
	public Player() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public float getWinRatio() {
		return winRatio;
	}


	public void setWinRatio(float winRatio) {
		this.winRatio = winRatio;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", winRatio=" + winRatio + "]";
	
	}
	
	
}
