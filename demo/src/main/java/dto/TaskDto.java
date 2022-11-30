package dto;

import java.util.Date;

public class TaskDto {

	private int id;
	private Date start_date;
	private Date end_date;
	private Boolean isComplete;
	
	public TaskDto() {}

	public TaskDto(int id, Date start_date, Date end_date, Boolean isComplete) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.isComplete = isComplete;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	public int getId() {
		return id;
	}

}