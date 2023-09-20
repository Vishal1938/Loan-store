package in.rdsit.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class AggregateResult {
    private String groupByField;  // Field by which the aggregation is grouped (e.g., lenderId, customerId)
    private BigDecimal totalRemainingAmount;
    private BigDecimal totalInterest;
    private BigDecimal totalPenalty;
    private int interestPerDay;
    

    
    public AggregateResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AggregateResult(String groupByField, BigDecimal totalRemainingAmount, BigDecimal totalInterest,
			BigDecimal totalPenalty, int interestPerDay) {
		super();
		this.groupByField = groupByField;
		this.totalRemainingAmount = totalRemainingAmount;
		this.totalInterest = totalInterest;
		this.totalPenalty = totalPenalty;
		this.interestPerDay = interestPerDay;
	}

    public int getInterestPerDay() {
		return interestPerDay;
	}

	public void setInterestPerDay(int interestPerDay) {
		this.interestPerDay = interestPerDay;
	}

    public String getGroupByField() {
        return groupByField;
    }

    public BigDecimal getTotalRemainingAmount() {
        return totalRemainingAmount;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public BigDecimal getTotalPenalty() {
        return totalPenalty;
    }
}

