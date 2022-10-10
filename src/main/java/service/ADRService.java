package service;

import com.google.protobuf.ServiceException;
import model.AdverseReaction;
import model.Relationship;
import model.RelationshipType;
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
//
//    boolean delete(Date reportDate, Reporter reporter) throws ServiceException;
//
//    public boolean update(int id, String description, String suspectedDrug, Outcome outcome, Criteria criteria)
//            throws ServiceException;
//
//    int getId(AdverseReaction adverseReaction);
}
