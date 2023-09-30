package dao.loan;

import model.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanDAOImpl implements LoanDAO{
    private final Map<Long, Loan> loanMap = new HashMap<>(); //map para guardar todos emprestimos feitos
    public Map<Long, Loan> getLoanMap() { //para retornar o banco de dados com todos livros cadastrados em  formato map
        return loanMap;
    }
    private long nextId = 0;

    public long getNextId() {
        /**
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++; // retorna ID para o objeto atual e define o próximo ID
    }
    @Override
    public Loan creat(Loan loan) {
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
