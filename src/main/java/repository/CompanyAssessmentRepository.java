package repository;

public interface CompanyAssessmentRepository {

    void save(CompanyAssessment companyAssessment);
    int getID(CompanyAssessment relationshipByCompany/ companyAssessment);
    CompanyAssessment getById(int id);
}
