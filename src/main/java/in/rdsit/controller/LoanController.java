package in.rdsit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rdsit.entity.Loan;
import in.rdsit.exception.NotFoundException;
import in.rdsit.service.LoanService;
import in.rdsit.util.AggregateResult;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        try {
            Loan addedLoan = loanService.addLoan(loan);
            return new ResponseEntity<>(addedLoan, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<Loan> getLoanById(@PathVariable String loanId) {
        try {
            Loan loan = loanService.getLoansById(loanId);
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Loan>> getLoansByCustomerId(@PathVariable String customerId) {
        List<Loan> loans = loanService.getLoansByCustomerId(customerId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/lender/{lenderId}")
    public ResponseEntity<List<Loan>> getLoansByLenderId(@PathVariable String lenderId) {
        List<Loan> loans = loanService.getLoansByLenderId(lenderId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/aggregate/lender")
    public ResponseEntity<List<AggregateResult>> aggregateLoansByLender() {
        List<AggregateResult> results = loanService.aggregateLoansByLender();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/aggregate/customer")
    public ResponseEntity<List<AggregateResult>> aggregateLoansByCustomerId() {
        List<AggregateResult> results = loanService.aggregateLoansByCustomerId();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/aggregate/interest")
    public ResponseEntity<List<AggregateResult>> aggregateLoansByInterest() {
        List<AggregateResult> results = loanService.aggregateLoansByInterest();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    // Implement other REST endpoints and exception handling as needed
}


