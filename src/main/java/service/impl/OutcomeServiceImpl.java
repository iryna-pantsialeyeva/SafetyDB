package service.impl;

import model.Outcome;
import service.OutcomeService;
import repository.*;

public class OutcomeServiceImpl implements OutcomeService {

    private OutcomeRepository outcomeRepository;

    public OutcomeServiceImpl() {
        outcomeRepository = new OutcomeRepositoryImpl();
    }

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
        return outcomeRepository.getId(name);
    }
}
