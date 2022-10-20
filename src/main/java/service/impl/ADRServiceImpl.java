package service.impl;

import model.AdverseReaction;
import model.AnswerType;
import model.Criteria;
import model.Outcome;
import model.RelationshipType;
import repository.AdverseReactionRepository;
import repository.impl.AdverseReactionRepositoryImpl;
import service.ADRService;
import service.ServiceException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private AdverseReactionRepository adverseReactionRepository;

    public ADRServiceImpl() {
        adverseReactionRepository = new AdverseReactionRepositoryImpl();
    }

    @Override
    public void save(AdverseReaction adverseReaction) throws ServiceException {
        try {
            adverseReactionRepository.save(adverseReaction);
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<AdverseReaction> getAll() {
        List<AdverseReaction> adverseReactions = adverseReactionRepository.getAll();
        return adverseReactions;
    }

    @Override
    public void delete(int id) {
        //adverseReactionRepository.delete(id);
        // TODO: 21.10.2022 edit after repository method creation by Ilya  
        System.out.println("Adverse reaction was deleted.");
    }

    @Override
    public void update(AdverseReaction adverseReaction) {
        //adverseReactionRepository.update(adverseReaction);
        // TODO: 21.10.2022 edit after repository method creation by Ilya 
        System.out.println(adverseReaction);
    }


    @Override
    public AdverseReaction getByID(int id) {
        AdverseReaction adverseReaction = new AdverseReaction(5,LocalDate.now(),"rash", "Panadol", Outcome.RECOVERED,
                Criteria.CONGENITAL_ANOMALY, null, RelationshipType.CERTAIN, RelationshipType.POSSIBLE,
                AnswerType.YES, AnswerType.NA, AnswerType.NO, AnswerType.NO, true);
        return adverseReaction;
        // TODO: 21.10.2022 edit after repository method creation by Ilya 
        //return adverseReactionRepository.getByID(id);
    }
}
