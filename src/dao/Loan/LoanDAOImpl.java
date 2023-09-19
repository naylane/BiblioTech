package dao.Loan;

import model.Book;
import model.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanDAOImpl implements LoanDAO{
    private final Map<Integer, Loan> loanmap = new HashMap<>(); //map para gaurdar todos emprestimos feitos
    @Override
    public Loan creat(Loan loan) {
        int id = loan.getIdLoan(); //aq guarda no map todos emprestimos, e a chave é o id do emprestimo
        loanmap.put(id, loan);
        return loan;}
    @Override
    public List<Loan> findAll() {
        //retorna uma lista de emprestimos
        return new ArrayList<>(loanmap.values());}
    @Override
    public Loan findById(int id) {
        return loanmap.get(id);
    } //retorna o emprestimo pelo id
    @Override
    public Loan update(Loan loan) {
        loanmap.put(loan.getIdLoan(), loan);
        return null;}
    @Override
    public void delete(Loan loan) {
        int id = loan.getIdLoan();
        loanmap.remove(id);}
    public Loan returnLoan(Loan loan) {
        return loan;
    }
}
