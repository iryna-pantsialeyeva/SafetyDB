package service.impl;

import model.Reporter;
import service.ReporterService;
import repository.*;

public class ReporterServiceImpl implements ReporterService {

    private ReporterRepository reporterRepository;

    public ReporterServiceImpl() {
        reporterRepository = new ReporterRepositoryImpl();
    }

    @Override
    public Reporter add(String fullName) {
       Reporter reporter = null;
       if(getId(fullName) == 0) {
           reporter = new Reporter(fullName);
       }
        return reporter;
    }

    @Override
    public int getId(String fullName) {
        return reporterRepository.getId(fullName);
    }
}
