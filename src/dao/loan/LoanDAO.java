package dao.loan;

import dao.CRUD;
import model.Loan;

import java.util.Map;

public interface LoanDAO extends CRUD<Loan> {
    public Map<Long, Loan> getLoanMap();
}
