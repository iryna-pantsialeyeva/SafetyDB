package repository;

import model.Reporter;

public interface ReporterRepository {

    Reporter getById(int id);
    Reporter getByName(String name);
    Reporter add(Reporter reporter);
    int getId(String name);


}
