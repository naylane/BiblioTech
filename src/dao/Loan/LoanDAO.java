package dao.Loan;

import dao.CRUD;
import model.Loan;

public interface LoanDAO extends CRUD<Loan> {
    public Loan returnLoan(Loan loan);
}
