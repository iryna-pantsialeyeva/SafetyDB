package service;

import com.google.protobuf.ServiceException;
import model.AdverseReaction;
import java.util.List;

public interface ADRService {

    void save(String description, String suspectedDrug, String outcome, String criteria, String userEmail,
                 String reporterFullName, String reporterType, String nameGivenByReporter, String timeRelationship,
                 String withdrawalResult, String reintroductionResult, String otherExplanation) throws ServiceException;

    List<AdverseReaction> getAll();
}
