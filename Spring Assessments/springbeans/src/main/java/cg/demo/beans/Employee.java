package cg.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// object to be created by framework is Component
@Component("emp1")
@Scope("prototype")

public class Employee {
	private int eid;
	private String ename;
	private int esalary;
	@Autowired // works like this also for address, but rest eid, ename and esalary are set to
				// NULL, because by default object will be created using default constructor, if
				// default constructor is removed, forcefully parameterized constructor is being called

	
//	so if Autowired is written above data member, then default constructor is given priority
//	else parameterized is considered
	private Address address;

//	public Employee() {
//	}

//	Constructor Annotations
//	But for Autowiring, this is not the right place, right it above constructor, else NULL

//	@Autowired 
	public Employee(@Value("101") int eid, @Value("Akshay Kumar") String ename, @Value("85000") int esalary,
			Address address) {
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

//	@Autowired // by default it is byType
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", address="
				+ (address != null ? address.toString() : " None ") + "]";
	}

	public void greet() {
		System.out.println("Welcome to Capgemini");
	}

	public int getEid() {
		return eid;
	}

//	@Value("101")
	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

//	@Value("Akshay Kumar")
	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEsalary() {
		return esalary;
	}

//	@Value("85000")
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}

}
