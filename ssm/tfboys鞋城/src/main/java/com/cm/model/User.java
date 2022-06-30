package com.cm.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime registrationDate;
	private int status;

	public User() {
	}

	public User(int id, String username, String password, String email, LocalDateTime registrationDate, int status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.registrationDate = registrationDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", registrationDate=" + registrationDate +
				", status=" + status +
				'}';
	}
}
