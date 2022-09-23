package service;

import model.Reporter;

public interface ReporterService {

    void add(String fullName);

    int getId(String fullName);
}
