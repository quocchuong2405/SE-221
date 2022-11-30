package dto;

public class MCPDto {

	private int id;
	private float fullness;
	private float altitude;

	public MCPDto() {}
	

	public MCPDto(int id, float fullness, float altitude) {
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
