package in.rdsit.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rdsit.entity.Loan;
import in.rdsit.repository.LoanRepository;
import in.rdsit.util.AggregateResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    
    private static final Logger logger = LogManager.getLogger(LoanService.class);
    public Loan addLoan(Loan loan) {
        // Validate payment date vs. due date
        if (loan.getPaymentDate().isAfter(loan.getDueDate())) {
            throw new IllegalArgumentException("Payment date cannot be greater than the due date");
        }
        
        // Save the loan
        return loanRepository.save(loan);
    }

    public List<Loan> getLoansByCustomerId(String customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

    public List<Loan> getLoansByLenderId(String lenderId) {
        return loanRepository.findByLenderId(lenderId);
    }
    
    public List<Loan> getLoansByInterestPerDay(int interestPerDay) {
        return loanRepository.findByInterestPerDay(interestPerDay);
    }
    
    public List<AggregateResult> aggregateLoansByLender() {
        return loanRepository.aggregateLoansByLender();
    }
    
    public List<AggregateResult> aggregateLoansByCustomerId() {
        return loanRepository.aggregateLoansByCustomerId();
    }

    public List<Loan> getLoansCrossingDueDate(LocalDate currentDate) {
        List<Loan> loans = loanRepository.findByDueDateBefore(currentDate);

        for (Loan loan : loans) {
            // Log an alert for each loan that has crossed the due date
            logger.warn("Loan with ID " + loan.getId() + " has crossed the due date.");
        }

        return loans;
    }

	public List<Loan> getAllLoans() {
		// TODO Auto-generated method stub
		return loanRepository.findAll();
		
	}

	public Loan getLoansById(String loanId) {
		// TODO Auto-generated method stub
		 return loanRepository.findByLoanId(loanId);
	}

	public List<AggregateResult> aggregateLoansByInterest() {
		// TODO Auto-generated method stub
		return loanRepository.aggregateLoansByInterest();
		
	}
}
