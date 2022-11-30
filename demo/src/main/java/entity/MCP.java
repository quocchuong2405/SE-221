package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mcps")
public class MCP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float fullness;
	private float altitude;

	public MCP() {}
	

	public MCP(int id, float fullness, float altitude) {
		super();
		this.id = id;
		this.fullness = fullness;
		this.altitude = altitude;
	}


	public float getFullness() {
		return fullness;
	}

	public void setFullness(float fullness) {
		this.fullness = fullness;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public int getId() {
		return id;
	}
	


}
