package service.impl;


import model.*;
import service.*;
import repository.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private AdverseReactionRepository adRepository;
    private ReporterService reporter;
    private CriteriaService criteria;
    private OutcomeService outcome;
    private TypeService type;

    public ADRServiceImpl() {
        adRepository = new AdverseReactionRepositoryImpl();
        reporter = new ReporterServiceImpl();
        criteria = new CriteriaServiceImpl();
        outcome = new OutcomeServiceImpl();
        type = new TypeServiceImpl();
    }

    public boolean save(AdverseReaction adverseReaction) {
        String outcomeToAdd = adverseReaction.getOutcome().getName();
        String criteriaToAdd = adverseReaction.getCriteria().getName();
        String typeToAdd = adverseReaction.getType().getName();
        String reporterToAdd = adverseReaction.getFullName().getFullName();

        outcome.save(outcomeToAdd);
        criteria.save(criteriaToAdd);
        type.save(typeToAdd);
        reporter.add(reporterToAdd);

        if (getId(adverseReaction) != 0) {
            adRepository.save(adverseReaction);
            return true;
        }
        return false;
    }

    @Override
    public List<AdverseReaction> get(String suspectedDrug) throws ServiceException {
        List<AdverseReaction> adverseReactionList = adRepository.get(suspectedDrug);
        if (adverseReactionList.get(0) == null) {
            throw new ServiceException("There are no reports on this medicinal product in database.");
        }
        return adverseReactionList;
    }

    // для метода update - 1. reporter вводит свое ФИО и получает список побочных реакций, выбирает id нужной реакции
    public List<AdverseReaction> getByFullName(String fullName) throws ServiceException {
        List<AdverseReaction> adverseReactionList = adRepository.getByFullName(fullName);
        if (adverseReactionList.get(0) == null) {
            throw new ServiceException("There are no reports on this medicinal product in database.");
        }
        return adverseReactionList;
    }

    @Override
    public boolean delete(Date reportDate, Reporter fullName) throws ServiceException {
        try {
           adRepository.delete(reportDate, fullName);
           return true;
        } catch (SQLException e){
            throw new ServiceException("There are no reports regarding your request in database.", e);
        }
        return false;
    }

    // 2. в метод передается id,которую выбрал из списка, полученного методом getByFullName
    @Override
    public boolean update(int id, String description, String suspectedDrug, Outcome outcome, Criteria criteria)
            throws ServiceException {
        try{
            AdverseReaction adverseReaction = adRepository.getById(id);
            adverseReaction.setDescription(description);
            adverseReaction.setSuspectedDrug(suspectedDrug);
            adverseReaction.setOutcome(outcome);
            adverseReaction.setCriteria(criteria);
            adRepository.update(adverseReaction);
            return true;
        } catch (SQLException e) {
            throw new ServiceException("Something went wrong while updating.", e);
            return false;
        }
    }

    @Override
    public int getId(AdverseReaction adverseReaction) {
        return adRepository.getId(adverseReaction);
    }
}
