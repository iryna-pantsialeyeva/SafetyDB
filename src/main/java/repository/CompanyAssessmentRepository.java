package repository;

public interface CompanyAssessmentRepository {

    void save(CompanyAssessment companyAssessment);
    int getID(CompanyAssessment nameGivenByCompany);
    CompanyAssessment getByID(int id);
}
