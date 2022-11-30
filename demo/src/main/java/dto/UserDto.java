package dto;

import java.util.Date;

public class UserDto {

	private int id;
	private String username;
	private String email;
	private int phone_number;
	private Boolean isAvailable;
	private String password;
	private Date birthday;
	private Date regisdate;
	
	public UserDto() {}
	
	

	public UserDto(int id, String username, String email, int phone_number, Boolean isAvailable, String password,
			Date birthday, Date regisdate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone_number = phone_number;
		this.isAvailable = isAvailable;
		this.password = password;
		this.birthday = birthday;
		this.regisdate = regisdate;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegisdate() {
		return regisdate;
	}

	public void setRegisdate(Date regisdate) {
		this.regisdate = regisdate;
	}

	public int getId() {
		return id;
	}

}
