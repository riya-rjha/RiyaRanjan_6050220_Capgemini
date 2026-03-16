package cg.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("add1") // name of object mentioned, if not mentioned by default an object with first letter small of class is created
public class Address {
	private String address;
	private String city;
	private String state;
	private int zipCode;
	
	public Address() {
		System.out.println("Address constructor created and called");
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}

	public String getAddress() {
		return address;
	}

	@Value("B-35, Sector-5")
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	@Value("Ghaziabad")
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	@Value("Uttar Pradesh")
	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	@Value("20847")
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
