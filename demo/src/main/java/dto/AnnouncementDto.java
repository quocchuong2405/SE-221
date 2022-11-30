package dto;

import java.util.Date;

public class AnnouncementDto {

	private int id;
	private Date date_time;
	private String description;
	
	public AnnouncementDto() {}

	public AnnouncementDto(int id, Date date_time, String description) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.description = description;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

}
