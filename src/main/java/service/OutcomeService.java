package service;

import model.Outcome;
import model.enums.OutcomeType;

public interface OutcomeService {

    void save(OutcomeType name);

    int getId(OutcomeType name);
}
