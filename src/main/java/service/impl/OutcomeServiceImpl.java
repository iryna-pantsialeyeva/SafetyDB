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
    public void save(String name) {
        if (getId(name) == 0) {
            Outcome outcome = new Outcome(name);
            outcomeRepository.add(outcome);
        }
    }

    @Override
    public int getId(String name) {
        return outcomeRepository.getId(name);
    }
}
