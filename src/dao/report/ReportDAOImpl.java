package dao.report;

import model.Report;

public class ReportDAOImpl implements ReportDAO {
    private Report report;

    /**
     * Método que retorna o relatório já existente
     * @return relatório
     */
    public Report getReport() {
        if (this.report == null) {
            report = new Report();
        }
        return this.report;
    }

    /**
     * Método que salva o relatório passado no parâmetro como atributo da classe ReportDAOImpl
     * @param report relatório a criar
     * @return relatório criado
     */
    @Override
    public Report save(Report report) {
        this.report = report;
        return report;
    }

    /**
     * Método que deleta o relatório previamente criado
     * @param report relatório a ser deletado
     */
    @Override
    public void delete(Report report) {
        this.report = new Report(); // deleta um relatório ao criar outro, fazendo assim com que nunca seja nulo
    }

}
