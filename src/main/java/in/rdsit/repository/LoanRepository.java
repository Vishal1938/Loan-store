package in.rdsit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.rdsit.entity.Loan;
import in.rdsit.util.AggregateResult;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByCustomerId(String customerId);
    List<Loan> findByLenderId(String lenderId);
    List<Loan> findByInterestPerDay(int interestPerDay);
    
    // Custom query for aggregation by lender
    @Query("SELECT l.lenderId, SUM(l.remainingAmount), SUM(l.interestPerDay), SUM(l.penaltyPerDay) FROM Loan l GROUP BY l.lenderId")
    List<AggregateResult> aggregateLoansByLender();
    
    // Custom query for aggregation by customer ID
    @Query("SELECT l.customerId, SUM(l.remainingAmount), SUM(l.interestPerDay), SUM(l.penaltyPerDay) FROM Loan l GROUP BY l.customerId")
    List<AggregateResult> aggregateLoansByCustomerId();
    
    @Query("SELECT l.interestPerDay, SUM(l.remainingAmount), SUM(l.interestPerDay), SUM(l.penaltyPerDay) " +
            "FROM Loan l GROUP BY l.interestPerDay")
     List<AggregateResult> aggregateLoansByInterest();
    
    // Custom query for loans that have crossed the due date
    List<Loan> findByDueDateBefore(LocalDate currentDate);
    
	Loan findByLoanId(String loanId);
}


