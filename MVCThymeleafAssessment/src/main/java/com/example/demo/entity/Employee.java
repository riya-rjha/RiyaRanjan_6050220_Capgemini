package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "employeesAssessment")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;

	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Only alphabets allowed")
	private String empName;

	@Min(value = 1000, message = "Minimum salary is 1000")
	@Max(value = 500000, message = "Maximum salary is 500000")
	private Double empSal;

	@FutureOrPresent(message = "Only now or future dates allowed")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate empDoj;

	@Pattern(regexp = "^(hr|production)$", message = "Dept must be hr or production")
	private String deptName;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(LocalDate empDoj) {
		this.empDoj = empDoj;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}