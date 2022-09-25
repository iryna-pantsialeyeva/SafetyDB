package service.impl;

import model.Reporter;
import model.Type;
import model.enums.ReporterType;
import service.ReporterService;
import repository.*;

public class ReporterServiceImpl implements ReporterService {

    private ReporterRepository reporterRepository;

    public ReporterServiceImpl() {
        reporterRepository = new ReporterRepositoryImpl();
    }

    @Override
    public void add(String fullName, Type type) {
        if(getId(fullName) == 0) {
           Reporter reporter = new Reporter(fullName, type);
           reporterRepository.add(reporter);
       }
    }

    @Override
    public int getId(String fullName) {
        return reporterRepository.getId(fullName);
    }

    public Reporter getByID(int id) {
        return reporterRepository.getByID(id);
    }
}
