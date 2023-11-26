package dao.report;

import dao.FileControl;
import exceptions.LoanException;
import model.Report;

public class ReportDAOImpl implements ReportDAO {
    private Report report;

    public ReportDAOImpl() throws Exception {
        this.report = FileControl.loadReport();
    }

    public Report getReport() throws LoanException {
        if (this.report == null) {
            this.report = new Report();
        }
        return this.report;
    }

    @Override
    public Report save(Report report) {
        FileControl.saveReport(report);
        return report;
    }

    @Override
    public void delete(Report report) throws LoanException {
        this.report = new Report(); // deleta um relatório ao criar outro, fazendo assim com que nunca seja nulo
        FileControl.saveReport(report);
    }

}
