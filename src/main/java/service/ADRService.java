package service;

import com.google.protobuf.ServiceException;
import model.AdverseReaction;
import model.Relationship;
import model.RelationshipType;
import repository.RepositoryException;

import java.time.LocalDate;
import java.util.List;

public interface ADRService {

    void save(String description, String suspectedDrug, String outcome, String criteria, String userEmail,
              String reporterFullName, String reporterType, String nameGivenByReporter, String timeRelationship,
              String withdrawalResult, String reintroductionResult, String otherExplanation) throws ServiceException;
//
//    List<AdverseReaction> get(String suspectedDrug) throws ServiceException;

    List<AdverseReaction> getAll();

    //    AdverseReaction getByID(int id);
//
//    List<AdverseReaction> getByFullName(Reporter reporter) throws ServiceException;

    void delete(int id) throws ServiceException;

    void update(int id, String date, String description, String suspectedDrug, String outcome,
                String criteria, String userEmail, String reporterFullName, String reporterType,
                String nameGivenByReporter, String timeRelationship, String withdrawalResult,
                String reintroductionResult, String otherExplanation) throws ServiceException;
//
//    int getId(AdverseReaction adverseReaction);
}
