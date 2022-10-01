package service.impl;

import model.CompanyAssessment;
import model.Relationship;
import model.enums.RelationshipType;
import repository.impl.CompanyAssessmentRepositoryImpl;
import service.CompanyAssessmentService;
import repository.*;

public class CompanyAssessmentServiceImpl implements CompanyAssessmentService {

    CompanyAssessmentRepository companyAssessmentRepository;

    public CompanyAssessmentServiceImpl() {
        companyAssessmentRepository = new CompanyAssessmentRepositoryImpl();
    }

    @Override
    public CompanyAssessment evaluate(Relationship relationshipByReporter) {
        RelationshipType type = RelationshipType.POSSIBLE;
        //TODO: 27.09.2022 add implementation
        CompanyAssessment companyAssessment = new CompanyAssessment(type);
        return companyAssessment;
    }

    @Override
    public void save(CompanyAssessment companyAssessmentToAdd) {
        if (getId(companyAssessmentToAdd) == 0) {
            companyAssessmentRepository.save(companyAssessmentToAdd);
        }
    }

    @Override
    public CompanyAssessment getById(int id) {
        return companyAssessmentRepository.getByID(id);
    }

    @Override
    public int getId(CompanyAssessment relationshipByCompany) {
        return companyAssessmentRepository.getId(relationshipByCompany);
    }


}
