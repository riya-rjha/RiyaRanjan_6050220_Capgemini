package com.tcs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name field cannot be empty")
	private String applicantName;

	@Min(value = 1, message = "Amount must be greater than 0")
	@Max(value = 5000000, message = "Amount must not exceed Rs 5000000")
	private double loanAmount;

	private String status;

	public Loan() {
	}

	public Loan(String applicantName, double loanAmount, String status) {
		this.applicantName = applicantName;
		this.loanAmount = loanAmount;
		this.status = status;
	}

	@PrePersist
	public void setDefaultStatus() {
		if (this.status == null) {
			this.status = "PENDING";
		}
	}

	public Long getId() {
		return id;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}