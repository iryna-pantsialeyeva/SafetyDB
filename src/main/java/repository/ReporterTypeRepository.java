package repository;

import model.Reporter;
import model.Type;

public interface ReporterTypeRepository {

    Type getByID(int id);
    Type getByName(String name);
    Type add(Type type);

}
