package dao.Loan;

import model.Book;
import model.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanDAOImpl implements LoanDAO{
    private final Map<Long, Loan> loanMap = new HashMap<>(); //map para guardar todos emprestimos feitos

    @Override
    public Loan creat(Loan loan) {
        Book book = loan.getBook();
        book.setQuantity(book.getQuantity() - 1); // atualizando a quantidade de determinado livro disponível

        long id = loan.getIdLoan(); //aq guarda no map todos emprestimos, e a chave é o id do emprestimo
        loanMap.put(id, loan);

        return loan;
    }

    @Override
    public List<Loan> findAll() {
        //retorna uma lista de emprestimos
        return new ArrayList<>(loanMap.values());}

    @Override
    public Loan findById(long id) {
        try {
            return loanMap.get(id);
        } catch (Exception e) {
            System.out.println("Emprestimo não encontrado.");
            return null;
        }
    } //retorna o emprestimo pelo id

    @Override
    public Loan update(Loan loan) {
        loanMap.put(loan.getIdLoan(), loan);
        return null;
    }

    @Override
    public void delete(Loan loan) {
        long id = loan.getIdLoan();
        loanMap.remove(id);
    }

    public void deleteAll() {
        loanMap.clear();
    }

}
