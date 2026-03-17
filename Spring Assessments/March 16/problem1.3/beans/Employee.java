package cg.demos.springcore_assignments.beans;

public class Employee {
	private int employeeId;
	private String employeeName;
	private double salary;
	private String businessUnit;
	private int age;
//	private SBU sbu;
	
	//Assignment 1.1:
//	public Employee(int employeeId, String employeeName, double salary, String businessUnit, int age) {
//		super();
//		this.employeeId = employeeId;
//		this.employeeName = employeeName;
//		this.salary = salary;
//		this.businessUnit = businessUnit;
//		this.age = age;
//		
//	}
	
	
	//Assignment 1.2: Construtor injection (SBU object injected through Constructor Injection) 
//	public Employee(int employeeId, String employeeName, double salary, String businessUnit, int age, SBU sbu) {
//		super();
//		this.employeeId = employeeId;
//		this.employeeName = employeeName;
//		this.salary = salary;
//		this.businessUnit = businessUnit;
//		this.age = age;
//		this.sbu = sbu;
//	}
	
	//No argument constructor for setter injection (Assignment 1.3)
	public Employee() {
		super();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public SBU getSbu() {
//		return sbu;
//	}
//	public void setSbu(SBU sbu) {
//		this.sbu = sbu;
//	}
	
	//Assignment 1.1:
//	public void displayDetails() {
//		System.out.println("Employee Details");
//		System.out.println("----------------------");
//		System.out.println("Employee ID: " + employeeId);
//		System.out.println("Employee Name: " + employeeName);
//		System.out.println("Employee Salary: " + salary);
//		System.out.println("Employee BU: " + businessUnit);
//		System.out.println("Employee Age: " + age);
//		
//	}
//	Assignment 1.2
//	public void displayDetails() {
//		System.out.println("Employee Details");
//		System.out.println(" ----------------------");
//		System.out.println(" Employee ID: " + employeeId);
//		System.out.println(" Employee Name: " + employeeName);
//		System.out.println(" Employee Salary: " + salary);
//		System.out.println(" Employee BU: " + businessUnit);
//		System.out.println(" Employee Age: " + age);
//		System.out.println(sbu.getSbuDetails());
//		
//	}

	
	
	

}
