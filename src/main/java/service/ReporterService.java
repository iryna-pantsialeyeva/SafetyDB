package service;

import model.Reporter;

public interface ReporterService {

    void save(Reporter reporter);

    int getId(Reporter reporter);

    Reporter getById(int id);
}
