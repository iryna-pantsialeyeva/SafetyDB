package service.impl;

import model.*;
import repository.impl.AdverseReactionRepositoryImpl;
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
    private RelationshipService relationship;
    private CompanyAssessmentService companyAssessment;

    public ADRServiceImpl() {
        adRepository = new AdverseReactionRepositoryImpl();
        reporter = new ReporterServiceImpl();
        criteria = new CriteriaServiceImpl();
        outcome = new OutcomeServiceImpl();
        type = new TypeServiceImpl();
        relationship = new RelationshipServiceImpl();
        companyAssessment = new CompanyAssessmentServiceImpl();
    }

//    @Override
//    public boolean save(AdverseReaction adverseReaction) throws ServiceException {
//        Outcome outcomeToAdd = adverseReaction.getOutcome();
//        Criteria criteriaToAdd = adverseReaction.getCriteria();
//        Reporter reporterToAdd = adverseReaction.getReporter();
//        Type typeToAdd = reporterToAdd.getType();
//        Relationship relationshipToAdd = adverseReaction.getRelationship();
//        CompanyAssessment companyAssessmentToAdd = companyAssessment.evaluate(relationshipToAdd);
//
//        outcome.save(outcomeToAdd);
//        criteria.save(criteriaToAdd);
//        reporter.save(reporterToAdd);
//        type.save(typeToAdd);
//        relationship.save(relationshipToAdd);
//        companyAssessment.save(companyAssessmentToAdd);
//
//        adverseReaction.setRelationshipByCompany(companyAssessmentToAdd);
//
//        if (getId(adverseReaction) != 0) {
//            try {
//                adRepository.save(adverseReaction);
//            } catch (SQLException e) {
//                throw new ServiceException("Something went wrong. The report was not added. ", e);
//            }
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public List<AdverseReaction> get(String suspectedDrug) throws ServiceException {
//        List<AdverseReaction> adverseReactionList = adRepository.get(suspectedDrug);
//        if (adverseReactionList.get(0) == null) {
//            throw new ServiceException("There are no reports on this medicinal product in database.");
//        }
//        return adverseReactionList;
//    }

    @Override
    public List<AdverseReaction> getAll() {
        return adRepository.getAll();
    }

//    @Override
//    public AdverseReaction getByID(int id) {
//        return adRepository.getById(id);
//    }
//
//    // для метода update - 1. reporter вводит свое ФИО и получает список побочных реакций, выбирает id нужной реакции
//    @Override
//    public List<AdverseReaction> getByFullName(Reporter reporter) throws ServiceException {
//        List<AdverseReaction> adverseReactionList = adRepository.getByFullName(reporter.getFullName());
//        if (adverseReactionList.get(0) == null) {
//            throw new ServiceException("There are no reports on this medicinal product in database.");
//        }
//        return adverseReactionList;
//    }
//
//    @Override
//    public boolean delete(Date reportDate, Reporter reporter) throws ServiceException {
//        try {
//            adRepository.delete((java.sql.Date) reportDate, reporter);
//            return true;
//        } catch (SQLException e){
//            throw new ServiceException("There are no reports regarding your request in database.", e);
//        }
//    }
//
//    // 2. в метод передается id,которую выбрал из списка, полученного методом getByFullName
//    @Override
//    public boolean update(int id, String description, String suspectedDrug, Outcome outcome, Criteria criteria)
//            throws ServiceException {
//        try{
//            AdverseReaction adverseReaction = adRepository.getById(id);
//            adverseReaction.setDescription(description);
//            adverseReaction.setSuspectedDrug(suspectedDrug);
//            adverseReaction.setOutcome(outcome);
//            adverseReaction.setCriteria(criteria);
//            adRepository.update(adverseReaction);
//            return true;
//        } catch (SQLException e) {
//            throw new ServiceException("Something went wrong while updating.", e);
//        }
//    }
//
//    @Override
//    public int getId(AdverseReaction adverseReaction) {
//        return adRepository.getId(adverseReaction);
//    }
}
