package repository;

import model.Reporter;

public interface ReporterRepository {

    Reporter getByID(int id);
    Reporter getByName(String name);
    Reporter add(Reporter reporter);


}
