package repository;

public interface CompanyAssessmentRepository {

    void save(CompanyAssessment companyAssessment);
    int getId(CompanyAssessment relationshipByCompany/ companyAssessment);
    CompanyAssessment getById(int id);
}
