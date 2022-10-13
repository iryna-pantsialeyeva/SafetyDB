package service.impl;

import com.google.protobuf.ServiceException;
import model.AdverseReaction;
import model.AnswerType;
import model.Criteria;
import model.Outcome;
import model.Relationship;

import model.RelationshipType;
import model.Reporter;
import model.ReporterType;
import repository.AdverseReactionRepository;
import repository.ReporterRepository;
import repository.RepositoryException;
import repository.UserRepository;
import repository.impl.AdverseReactionRepositoryImpl;
import repository.impl.ReporterRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import service.ADRService;
import service.RelationshipService;
import service.ReporterService;
import service.UserService;
import service.validation.ServiceValidator;

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
//    @Override
//    public List<AdverseReaction> getByFullName(Reporter reporter) throws ServiceException {
//        List<AdverseReaction> adverseReactionList = adRepository.getByFullName(reporter.getFullName());
//        if (adverseReactionList.get(0) == null) {
//            throw new ServiceException("There are no reports on this medicinal product in database.");
//        }
//        return adverseReactionList;
//    }

    @Override
    public void delete(int id) throws ServiceException {
        AdverseReaction adverseReaction = adverseReactionRepository.getById(id);
        if(adverseReaction.getId() == 0) {
            throw new ServiceException("ID " + id + " is not found in the database.");
        }
        try {
            adverseReactionRepository.delete(id);
        } catch (RepositoryException e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(int id, String date, String description, String suspectedDrug, String outcome,
                       String criteria, String userEmail, String reporterFullName, String reporterType,
                       String nameGivenByReporter, String timeRelationship, String withdrawalResult,
                       String reintroductionResult, String otherExplanation) throws ServiceException {
    AdverseReaction adverseReaction = adverseReactionRepository.getById(id);
    if(adverseReaction.getId() == 0) {
        throw new ServiceException("ID " + id + " is not found in the database.");
    }
    if(!ServiceValidator.isDateFormatValid(date)) {
        throw new ServiceException("Date format is supposed to be \"YYYY-MM-DD\"");
    }
    adverseReaction.setReportDate(LocalDate.parse(date));
    adverseReaction.setDescription(description);
    adverseReaction.setSuspectedDrug(suspectedDrug);
    adverseReaction.setOutcome(Outcome.getOutcomeByLabel(outcome));
    adverseReaction.setCriteria(Criteria.getCriteriaByLabel(criteria));
    //userService.update(userRepository.getByEmail(userEmail));
    adverseReaction.setUser(userRepository.getByEmail(userEmail));
    Reporter reporter = adverseReaction.getReporter();
    reporter.setFullName(reporterFullName);
    reporter.setType(ReporterType.getReporterTypeByLabel(reporterType));
    reporterService.update(reporter);
    //adverseReaction.setReporter(reporter);
    Relationship relationship = adverseReaction.getRelationship();
    relationship.setNameGivenByReporter(RelationshipType.getRelationshipTypeByLabel(nameGivenByReporter));
    relationship.setTimeRelationship(AnswerType.getAnswerTypeByLabel(timeRelationship));
    relationship.setWithdrawalResult(AnswerType.getAnswerTypeByLabel(withdrawalResult));
    relationship.setReintroductionResult(AnswerType.getAnswerTypeByLabel(reintroductionResult));
    relationship.setOtherExplanation(AnswerType.getAnswerTypeByLabel(otherExplanation));
    relationshipService.update(relationship);
    //adverseReaction.setRelationship(relationship);
    adverseReaction.setRelationshipByCompany(relationshipService.evaluate(relationship));
    try {
        adverseReactionRepository.update(adverseReaction);
    } catch (RepositoryException e) {
        throw new ServiceException(e.getMessage());
    }
    }
//
//    @Override
//    public int getId(AdverseReaction adverseReaction) {
//        return adRepository.getId(adverseReaction);
//    }
}
