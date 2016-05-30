package be.pvgroup.services.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection=User.COLLECTION_NAME)
public class User {

	public static final String COLLECTION_NAME = "Users";
	
	@Id
	private Long id;
	private String firstName;
	private String name;
	private String email;
	private Integer seq;
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

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
