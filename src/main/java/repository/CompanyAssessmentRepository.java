package repository;

import model.CompanyAssessment;

public interface CompanyAssessmentRepository {

    void save(CompanyAssessment companyAssessment);
    int getId(CompanyAssessment nameGivenByCompany);
    CompanyAssessment getById(int id);
}
