package service.impl;

import model.Reporter;
import model.ReporterType;
import repository.ReporterRepository;
import repository.impl.ReporterRepositoryImpl;
import service.ReporterService;

public class ReporterServiceImpl implements ReporterService {

    private ReporterRepository reporterRepository;

    public ReporterServiceImpl() {
        reporterRepository = new ReporterRepositoryImpl();
    }

    @Override
    public void save(String reporterFullName, String reporterType) {
        Reporter reporter = new Reporter();
        reporter.setFullName(reporterFullName);
        reporter.setType(ReporterType.getReporterTypeByLabel(reporterType));
        if (getId(reporter) == 0) {
            reporterRepository.add(reporter);
        }
    }
}