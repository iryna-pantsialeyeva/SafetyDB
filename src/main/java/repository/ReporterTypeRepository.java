package repository;

import model.Reporter;
import model.Type;
import model.enums.ReporterType;

public interface ReporterTypeRepository {

    Type getById(int id);
    Type getByName(String name);
    Type add(Type type);
    int getId(ReporterType reporterType);

}
