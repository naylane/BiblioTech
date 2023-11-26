package dao.report;

import exceptions.LoanException;
import model.Report;

public interface ReportDAO {
    /**
     * Método que retorna o relatório já existente
     * @return relatório
     */
    public Report getReport() throws LoanException;

    /**
     * Método que salva o relatório passado no parâmetro.
     * @param report relatório a criar
     * @return relatório criado
     */
    Report save(Report report);

    /**
     * Método que deleta o relatório previamente criado
     * @param report relatório a ser deletado
     */
    void delete(Report report) throws LoanException;
}
