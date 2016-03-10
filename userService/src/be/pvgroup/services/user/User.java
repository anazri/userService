package be.pvgroup.services.user;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private Long id;
	private String firstName;
	private String name;
	private String email;
	
	public User() {
	}

	public User(Long id, String firstName, String name, String email) {
		this.id = id;
		this.firstName = firstName;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
