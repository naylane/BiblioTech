package dao.report;

import model.Report;

public interface ReportDAO {
    /**
     * Método que retorna o relatório já existente
     * @return relatório
     */
    Report getReport();

    /**
     * Método que salva o relatório passado no parâmetro como atributo da classe ReportDAOImpl
     * @param report relatório a criar
     * @return relatório criado
     */
    Report save(Report report);

    /**
     * Método que deleta o relatório previamente criado
     * @param report relatório a ser deletado
     */
    void delete(Report report);
}
