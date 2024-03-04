package mini.entity;

import java.time.LocalDate;

public class User {
	private String user_id;
	private String password ;
	private String username ;
	private String email;
	private String phone_number;
	private LocalDate regDate;
	private int isDeleted;
	
	public User() { }
	public User(String user_id, String password, String username, String email, String phone_number) {
		this.user_id = user_id;
		this.password = password;
		this.username = username;
		this.email = email;
		this.phone_number = phone_number;
	}
	
	public User(String user_id, String password, String username, String email, String phone_number, LocalDate regDate,
			int isDeleted) {
		this.user_id = user_id;
		this.password = password;
		this.username = username;
		this.email = email;
		this.phone_number = phone_number;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password + ", username=" + username + ", email=" + email
				+ ", phone_number=" + phone_number + ", regDate=" + regDate + ", isDeleted=" + isDeleted + "]";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
	