package poc.restdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "User")
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", allocationSize = 5)
	private Integer userId;

	private String name;

	@OneToOne
	private Address address;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
		super();
	}

	public User(Integer userId, String name, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", address=" + address + "]";
	}

}
