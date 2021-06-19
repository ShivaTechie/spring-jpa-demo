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
@Table(name = "Address")
@Component
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "address_seq")
	@SequenceGenerator(name = "address_seq", allocationSize = 5)
	private Integer addressId;

	private String city;

	private String state;

	@OneToOne(mappedBy = "address")
	private User user;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address(Integer addressId, String city, String state) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + "]";
	}

}
