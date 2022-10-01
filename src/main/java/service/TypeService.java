package service;

import model.Type;

public interface TypeService {

    void save(Type type);

    int getId(Type type);

    Type getByID(int id);
}
