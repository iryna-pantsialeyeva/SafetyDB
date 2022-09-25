package service.impl;

import model.CompanyAssessment;
import model.Outcome;
import model.Relationship;
import model.enums.OutcomeType;
import model.enums.RelationshipType;
import service.CompanyAssessmentService;
import repository.*;

public class CompanyAssessmentServiceImpl implements CompanyAssessmentService {

    CompanyAssessmentRepository companyAssessmentRepository;

    public CompanyAssessmentServiceImpl() {
        companyAssessmentRepository = new CompanyAssessmentRepositoryImpl();
    }

    @Override
    public RelationshipType evaluate(Relationship relationshipByReporter) {
        return RelationshipType.POSSIBLE;
    }

    @Override
    public void save(CompanyAssessment companyAssessmentToAdd) {
        if (getId(companyAssessmentToAdd) == 0) {
            companyAssessmentRepository.add(companyAssessmentToAdd);
        }
    }

    @Override
    public int getId(CompanyAssessment relationshipByCompany) {
        return companyAssessmentRepository.getId(relationshipByCompany);
    }

    public CompanyAssessment getById(int id) {
        return companyAssessmentRepository.getById(id);
    }
}
