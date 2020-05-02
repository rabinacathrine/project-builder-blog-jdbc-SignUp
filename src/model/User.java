package model;

import java.time.LocalDate;

public class User{
	private String email;
	private String password;
	private LocalDate signupdate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDate() {
		return signupdate;
	}
	public void setDate(LocalDate date) {
		this.signupdate = date;
	}
}