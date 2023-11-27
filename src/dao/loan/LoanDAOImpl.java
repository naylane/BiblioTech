package dao.loan;

import dao.FileControl;
import exceptions.LoanException;
import model.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoanDAOImpl implements LoanDAO {
    private HashMap<Long, Loan> loanMap;
    private long nextId;

    public LoanDAOImpl() throws LoanException {
        this.loanMap = FileControl.loadLoan();
        this.nextId = loanMap.size();
    }

    public long getNextId() {
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++;
    }

    public HashMap<Long, Loan> getLoanMap() { return loanMap; }

    @Override
    public Loan create(Loan loan) {
        loan.setId(getNextId());
        loanMap.put(loan.getId(), loan);
        FileControl.saveLoan(this.loanMap);
        return loan;
    }

    @Override
    public List<Loan> findAll() {
        return new ArrayList<>(loanMap.values());}

    @Override
    public Loan findById(long id) {
        try {
            return loanMap.get(id);
        } catch (Exception e) {
            System.out.println("Emprestimo não encontrado.");
            return null;
        }
    }

    @Override
    public Loan update(Loan loan) {
        loanMap.put(loan.getIdLoan(), loan);
        FileControl.saveLoan(this.loanMap);
        return null;
    }

    @Override
    public void delete(Loan loan) {
        long id = loan.getIdLoan();
        loanMap.remove(id);
        FileControl.saveLoan(this.loanMap);
    }

    public void deleteAll() {
        loanMap.clear();
        FileControl.saveLoan(this.loanMap);
    }

}
