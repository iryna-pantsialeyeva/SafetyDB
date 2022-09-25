package service;

import model.Type;
import model.enums.ReporterType;

public interface TypeService {

    void save(ReporterType name);

    int getId(ReporterType name);

    Type getByID(int id);
}
