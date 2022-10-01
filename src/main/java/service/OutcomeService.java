package service;

import model.Outcome;

public interface OutcomeService {

    void save(Outcome outcome);

    Outcome getByID(int id);

    int getId(Outcome outcome);
}
