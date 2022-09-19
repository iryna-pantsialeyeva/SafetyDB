package service;

import model.Outcome;

public class OutcomeServiceImpl implements OutcomeService {
    @Override
    public Outcome save(String name) {
        Outcome outcome = null;
        if (!isPresent(name)) {
            outcome = new Outcome(name);
        }
        return outcome;
    }

    @Override
    public boolean isPresent(String name) {
        if (getId(name) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getId(String name) {
        // TODO: 19.09.2022 add method after Repository layer method implementation
        return 0;
    }
}
