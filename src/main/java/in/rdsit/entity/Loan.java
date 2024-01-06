package in.rdsit.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loanId;
    private String customerId;
    private String lenderId;
    private BigDecimal amount;
    private BigDecimal remainingAmount;
    private LocalDate paymentDate;
    private int interestPerDay;
    private LocalDate dueDate;
    private BigDecimal penaltyPerDay;
    private boolean canceled;
    private String status;
    
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Loan(Long id, String loanId, String customerId, String lenderId, BigDecimal amount,
			BigDecimal remainingAmount, LocalDate paymentDate, int interestPerDay, LocalDate dueDate,
			BigDecimal penaltyPerDay, boolean canceled,String status) {
		super();
		this.id = id;
		this.loanId = loanId;
		this.customerId = customerId;
		this.lenderId = lenderId;
		this.amount = amount;
		this.remainingAmount = remainingAmount;
		this.paymentDate = paymentDate;
		this.interestPerDay = interestPerDay;
		this.dueDate = dueDate;
		this.penaltyPerDay = penaltyPerDay;
		this.canceled = canceled;
		this.status=status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getLenderId() {
		return lenderId;
	}
	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getInterestPerDay() {
		return interestPerDay;
	}
	public void setInterestPerDay(int interestPerDay) {
		this.interestPerDay = interestPerDay;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getPenaltyPerDay() {
		return penaltyPerDay;
	}
	public void setPenaltyPerDay(BigDecimal penaltyPerDay) {
		this.penaltyPerDay = penaltyPerDay;
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
