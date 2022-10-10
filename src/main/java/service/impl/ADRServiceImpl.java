package service.impl;

import com.google.protobuf.ServiceException;
import model.AdverseReaction;
import model.Criteria;
import model.Outcome;
import model.Relationship;

import repository.AdverseReactionRepository;
import repository.ReporterRepository;
import repository.UserRepository;
import repository.impl.AdverseReactionRepositoryImpl;
import repository.impl.ReporterRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import service.ADRService;
import service.RelationshipService;
import service.ReporterService;
import service.UserService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private AdverseReactionRepository adverseReactionRepository;
    private ReporterService reporterService;
    private RelationshipService relationshipService;
    private UserService userService;
    private UserRepository userRepository;
    private ReporterRepository reporterRepository;

    public ADRServiceImpl() {
        adverseReactionRepository = new AdverseReactionRepositoryImpl();
        reporterService = new ReporterServiceImpl();
        relationshipService = new RelationshipServiceImpl();
        userService = new UserServiceImpl();
        userRepository = new UserRepositoryImpl();
        reporterRepository = new ReporterRepositoryImpl();
    }

    @Override
    public void save(String description, String suspectedDrug, String outcome, String criteria, String userEmail,
                        String reporterFullName, String reporterType, String nameGivenByReporter, String timeRelationship,
                        String withdrawalResult, String reintroductionResult, String otherExplanation)
            throws ServiceException {
        AdverseReaction adverseReaction = new AdverseReaction();
        adverseReaction.setReportDate(LocalDate.now());
        adverseReaction.setDescription(description);
        adverseReaction.setSuspectedDrug(suspectedDrug);
        adverseReaction.setOutcome(Outcome.getOutcomeByLabel(outcome));
        adverseReaction.setCriteria(Criteria.getCriteriaByLabel(criteria));
        adverseReaction.setUser(userRepository.getByEmail(userEmail));
        reporterService.save(reporterFullName, reporterType);
        adverseReaction.setReporter(reporterRepository.getByName(reporterFullName));
        Relationship relationship = relationshipService.save(nameGivenByReporter, timeRelationship, withdrawalResult,
                reintroductionResult, otherExplanation);
        adverseReaction.setRelationship(relationshipService.getById(relationshipService.getId(relationship)));
        adverseReaction.setRelationshipByCompany(relationshipService.evaluate(relationship));
        try {
            adverseReactionRepository.save(adverseReaction);
        } catch (SQLException e) {
            throw new ServiceException("Error while saving in the database.", e);
        }
    }

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
        List<AdverseReaction> adverseReactions = adverseReactionRepository.getAll();
        adverseReactions.forEach(reaction -> reaction.setUser(userService.getById(reaction.getUser().getId())));
        adverseReactions.forEach(reaction -> reaction.setReporter(reporterService.getById(reaction.getReporter().getId())));
        adverseReactions.forEach(reaction -> reaction.setRelationship(relationshipService.getById(reaction.getRelationship().getId())));
        return adverseReactions;
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
