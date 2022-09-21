package service;

import model.Outcome;

public interface OutcomeService {

    Outcome save(String name);

    int getId(String name);
}
