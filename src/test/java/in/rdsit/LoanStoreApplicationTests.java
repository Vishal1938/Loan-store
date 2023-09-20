package in.rdsit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import in.rdsit.entity.Loan;
import in.rdsit.repository.LoanRepository;
import in.rdsit.service.LoanService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
public class LoanStoreApplicationTests {

    @InjectMocks
    private LoanService loanService;

    @Mock
    private LoanRepository loanRepository;

    @Test
    public void testAddValidLoan() {
        
        Loan loanToAdd = new Loan();
        loanToAdd.setPaymentDate(LocalDate.of(2023, 5, 6));
        loanToAdd.setDueDate(LocalDate.of(2023, 5, 7));
        
        Mockito.when(loanRepository.save(any(Loan.class))).thenReturn(loanToAdd);
        
        
        Loan addedLoan = loanService.addLoan(loanToAdd);
        
        assertNotNull(addedLoan);
        assertEquals(LocalDate.of(2023, 5, 6), addedLoan.getPaymentDate());
        assertEquals(LocalDate.of(2023, 5, 7), addedLoan.getDueDate());
    }

    @Test
    public void testAddLoanWithInvalidPaymentDate() {
       
        Loan loanToAdd = new Loan();
        loanToAdd.setPaymentDate(LocalDate.of(2023, 5, 8));
        loanToAdd.setDueDate(LocalDate.of(2023, 5, 7));
        
       
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.addLoan(loanToAdd);
        });
    }

    @Test
    public void testGetLoansByCustomerId() {
        
        String customerId = "C1";
        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan());
        
        Mockito.when(loanRepository.findByCustomerId(customerId)).thenReturn(loans);
        
    
        List<Loan> result = loanService.getLoansByCustomerId(customerId);
        
        
        assertEquals(1, result.size());
    }

}

