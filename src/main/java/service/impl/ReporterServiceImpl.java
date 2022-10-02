package service.impl;

import model.Reporter;
import repository.impl.ReporterRepositoryImpl;
import service.ReporterService;
import repository.*;

public class ReporterServiceImpl implements ReporterService {

    private ReporterRepository reporterRepository;

    public ReporterServiceImpl() {
        reporterRepository = new ReporterRepositoryImpl();
    }
//
//    @Override
//    public void save(Reporter reporter) {
//        if(getId(reporter) == 0) {
//            reporterRepository.add(reporter);
//        }
//    }
//
//    @Override
//    public int getId(Reporter reporter) {
//        return reporterRepository.getId(reporter.getFullName());
//    }
//
//    @Override
//    public Reporter getById(int id) {
//        return reporterRepository.getById(id);
//    }
}