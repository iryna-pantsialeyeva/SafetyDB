package service;

import model.Reporter;

public interface ReporterService {

    Reporter add(String fullName);

    boolean isPresent(String fullName);

    int getId(String fullName);
}
