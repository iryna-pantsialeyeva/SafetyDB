package service;

import model.Reporter;
import model.Type;
import model.enums.ReporterType;

public interface ReporterService {

    void add(String fullName, Type type);

    int getId(String fullName);

    Reporter getByID(int id);
}
