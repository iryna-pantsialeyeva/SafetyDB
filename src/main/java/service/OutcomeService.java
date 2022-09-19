package service;

import model.Outcome;

public interface OutcomeService {

    Outcome save(String name);

    boolean isPresent(String name);

    int getId(String name);
}
