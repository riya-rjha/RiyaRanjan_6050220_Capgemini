package com.tcs.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.Loan;
import com.tcs.exceptions.DuplicateLoanApplicationException;
import com.tcs.exceptions.InvalidLoanAmountException;
import com.tcs.exceptions.LoanNotFoundException;
import com.tcs.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public Loan createLoan(Loan loan) {
		double amt = loan.getLoanAmount();
		if (amt <= 0 || amt > 5000000) {
			throw new InvalidLoanAmountException("Loan amount entered must be greater than 0 and less than 5000000");
		}

		Loan newLoan = loanRepository.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING");
		if (newLoan != null) {
			throw new DuplicateLoanApplicationException("A pending loan for user already exists");
		}
		loan.setStatus("PENDING");
		return loanRepository.save(loan);
	}

	@Override
	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

	@Override
	public Loan getLoanById(Long id) {
		Loan objToFind = loanRepository.findById(id).orElse(null);
		if (objToFind == null) {
			throw new LoanNotFoundException("No loan with the given id exists");
		}
		return objToFind;
	}

	@Override
	public Loan updateLoanStatus(Long id, String status) {
		Loan loan = getLoanById(id);
		loan.setStatus(status);
		return loanRepository.save(loan);
	}
}