package service.impl;

import model.Outcome;
import repository.impl.OutcomeRepositoryImpl;
import service.OutcomeService;
import repository.*;

public class OutcomeServiceImpl implements OutcomeService {

    private OutcomeRepository outcomeRepository;

    public OutcomeServiceImpl() {
        outcomeRepository = new OutcomeRepositoryImpl();
    }

    @Override
    public void save(Outcome outcome) {
        if (getId(outcome) == 0) {
            outcomeRepository.add(outcome);
        }
    }

    @Override
    public Outcome getById(int id) {
        return outcomeRepository.getById(id);
    }

    @Override
    public int getId(Outcome outcome) {
        return outcomeRepository.getId(outcome.getName());
    }
}
