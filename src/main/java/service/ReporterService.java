package service;

import model.Reporter;

public interface ReporterService {

    void save(String reporterFullName, String reporterType);

    int getId(Reporter reporter);

    Reporter getById(int id);

    void update(Reporter reporter);
}
