package service.impl;

import model.AnswerType;
import model.CompanyAssessment;
import model.Relationship;
import model.RelationshipType;
import repository.CompanyAssessmentRepository;
import repository.RelationshipRepository;
import repository.impl.CompanyAssessmentRepositoryImpl;
import service.CompanyAssessmentService;
import service.RelationshipService;
@Deprecated
public class CompanyAssessmentServiceImpl implements CompanyAssessmentService {

    CompanyAssessmentRepository companyAssessmentRepository;
    RelationshipService relationshipService;

    public CompanyAssessmentServiceImpl() {
        companyAssessmentRepository = new CompanyAssessmentRepositoryImpl();
        relationshipService = new RelationshipServiceImpl();
    }

//    @Override
//    public void save(RelationshipType relationshipByCompany) {
//        if (getId(relationshipByCompany) == 0) {
//            companyAssessmentRepository.save(relationshipByCompany);
//        }
//    }
//
//    @Override
//    public CompanyAssessment getById(int id) {
//        return companyAssessmentRepository.getById(id);
//    }
//
//    @Override
//    public int getId(RelationshipType relationshipByCompany) {
//        return companyAssessmentRepository.getId(relationshipByCompany);
//    }
}
