package dao.loan;

import dao.CRUD;
import model.Loan;

import java.util.HashMap;

public interface LoanDAO extends CRUD<Loan> {
    public HashMap<Long, Loan> getLoanMap();
    public long getNextId();
}
