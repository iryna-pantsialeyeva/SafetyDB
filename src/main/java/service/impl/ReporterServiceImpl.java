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
    public void add(String fullName) {
        if(getId(fullName) == 0) {
           Reporter reporter = new Reporter(fullName);
       }
    }

    @Override
    public int getId(String fullName) {
        return reporterRepository.getId(fullName);
    }
}
