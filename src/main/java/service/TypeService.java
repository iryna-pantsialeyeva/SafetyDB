package service;

import model.Type;

public interface TypeService {

    Type save(String name);

    boolean isPresent(String name);

    int getId(String name);
}
