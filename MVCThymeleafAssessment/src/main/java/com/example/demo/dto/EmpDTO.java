package com.example.demo.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class EmpDTO {

	private Integer empId;

	@NotBlank(message = "Name cannot be empty in Employee")
	@Size(min = 3, max = 25, message = "Name should have minimum 3 and maximum 25 characters only")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Onl alphabets are allowed")
	private String empName;

	@Min(value = 1000, message = "Min val should be 1000")
	@Max(value = 500000, message = "Max val should be 500000")
	private Double empSal;

	@FutureOrPresent(message = "Date must be current or future")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate empDoj;

	@Pattern(regexp = "^(hr|production)$", message = "Enter only HR or Production")
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