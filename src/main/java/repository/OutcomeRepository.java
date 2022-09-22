package repository;

import model.Outcome;

public interface OutcomeRepository {

    Outcome getByID(int id);
    Outcome getByName(String name);
    Outcome add(Outcome outcome);

}
