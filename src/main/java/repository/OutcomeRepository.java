package repository;

import model.Outcome;
import model.OutcomeType;

public interface OutcomeRepository {

    Outcome getById(int id);
    Outcome getByName(String name);
    Outcome add(Outcome outcome);
    int getId(OutcomeType outcomeType);

}
