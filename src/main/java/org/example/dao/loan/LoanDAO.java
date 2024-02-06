package org.example.dao.loan;

import org.example.dao.CRUD;
import org.example.model.Loan;

import java.util.HashMap;

public interface LoanDAO extends CRUD<Loan> {
    public HashMap<Long, Loan> getLoanMap();
    public long getNextId();
}
