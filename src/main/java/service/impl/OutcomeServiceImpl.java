package service.impl;

import model.Outcome;
import service.OutcomeService;

public class OutcomeServiceImpl implements OutcomeService {
    @Override
    public Outcome save(String name) {
        Outcome outcome = null;
        if (getId(name) == 0) {
            outcome = new Outcome(name);
        }
        return outcome;
    }

    @Override
    public int getId(String name) {
        // TODO: 19.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
