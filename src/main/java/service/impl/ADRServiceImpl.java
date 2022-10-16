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

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ADRServiceImpl implements ADRService {

    private AdverseReactionRepository adverseReactionRepository;
    private ReporterService reporterService;
    private RelationshipService relationshipService;
    private UserRepository userRepository;
    private ReporterRepository reporterRepository;

    public ADRServiceImpl() {
        adverseReactionRepository = new AdverseReactionRepositoryImpl();
        reporterService = new ReporterServiceImpl();
        relationshipService = new RelationshipServiceImpl();
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

    @Override
    public List<AdverseReaction> getAll() {
        List<AdverseReaction> adverseReactions = adverseReactionRepository.getAll();
        adverseReactions.forEach(reaction -> reaction.setUser(userService.getById(reaction.getUser().getId())));
        adverseReactions.forEach(reaction -> reaction.setReporter(reporterService.getById(reaction.getReporter().getId())));
        adverseReactions.forEach(reaction -> reaction.setRelationship(relationshipService.getById(reaction.getRelationship().getId())));
        return adverseReactions;
    }
}
