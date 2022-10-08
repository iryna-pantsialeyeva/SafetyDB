package repository.impl;

import model.CompanyAssessment;
import model.RelationshipType;
import repository.CompanyAssessmentRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyAssessmentRepositoryImpl implements CompanyAssessmentRepository {

    public CompanyAssessmentRepositoryImpl() {}

    @Override
    public CompanyAssessment getById(int id) {
        CompanyAssessment companyAssessment = new CompanyAssessment();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_COMPANY_ASSESSMENT_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    companyAssessment.setId(rs.getInt("id"));
                    RelationshipType nameGivenByCompany = RelationshipType.valueOf(rs.getString("name"));
                    companyAssessment.setNameGivenByCompany(nameGivenByCompany);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyAssessment;
    }

    @Override
    public void save(CompanyAssessment companyAssessment) {
//        try(Connection con = ConnectionToDB.connectionPool.getConnection();
//            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_COMPANY_ASSESSMENT)) {
//
//            ps.setString(1, companyAssessment.getNameGivenByCompany());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int getId(CompanyAssessment nameGivenByCompany) {
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_COMPANY_ASSESSMENT_ID);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, nameGivenByCompany.getNameGivenByCompany());
//
//            if (rs.next()) {
//                id = rs.getInt("id");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return id;
    }
}
