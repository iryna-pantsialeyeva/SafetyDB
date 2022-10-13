package repository;

import model.Reporter;

public interface ReporterRepository {

    void add(Reporter reporter);
    void update(Reporter reporter);
    Reporter getById(int id);
    Reporter getByName(String name);
    int getId(String fullName);


}
