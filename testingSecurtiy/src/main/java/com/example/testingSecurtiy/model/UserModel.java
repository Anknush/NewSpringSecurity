package com.example.testingSecurtiy.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String name;
	private String username;
	private String email;
	private String password;
	private boolean isactive;
	private String roles;

	public UserModel() {

	}

	public UserModel(int id, String name, String username, String email, String password, boolean isactive,
			String roles) {
		super();
		Id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isactive = isactive;
		this.roles = roles;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = "ROLE_" + roles;
	}

	@Override
	public String toString() {
		return "UserModel [Id=" + Id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", isactive=" + isactive + ", roles=" + roles + "]";
	}

}
