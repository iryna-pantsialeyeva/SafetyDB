package service;

import model.CompanyAssessment;
import model.Relationship;
import model.enums.RelationshipType;

public interface CompanyAssessmentService {

    RelationshipType evaluate(Relationship relationshipByReporter);

    void save(CompanyAssessment companyAssessmentToAdd);

    int getId(CompanyAssessment relationshipByCompany);

    public CompanyAssessment getById(int id);
}
