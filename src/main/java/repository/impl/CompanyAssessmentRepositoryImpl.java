package repository.impl;

import repository.CompanyAssessmentRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyAssessmentRepositoryImpl implements CompanyAssessmentRepository {

    @Override
    public void save(CompanyAssessment companyAssessment) {
        try(Connection con = ConnectionToDB.connectionPool.getConnection();
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_COMPANY_ASSESSMENT)) {

            ps.setString(1, companyAssessment.getNameGivenByCompany());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getId(CompanyAssessment relationshipByCompany/ companyAssessment) {
        int id = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_COMPANY_ASSESSMENT_ID);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, companyAssessment.getNameGivenByCompany());

            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public CompanyAssessment getById(int id) {
        CompanyAssessment companyAssessment = new CompanyAssessment();
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_COMPANY_ASSESSMENT_BY_ID);
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);

            while (rs.next()) {
                companyAssessment.setNameGivenByCompany.valueOf(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyAssessment;
    }
}
