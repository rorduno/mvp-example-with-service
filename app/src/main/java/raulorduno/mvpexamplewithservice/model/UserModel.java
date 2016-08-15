package raulorduno.mvpexamplewithservice.model;

import java.io.Serializable;

// Model
public class UserModel implements Serializable {
	private String name;
	private String email;

	public UserModel() {}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Name : " + name + "\nEmail : " + email;
	}
}
