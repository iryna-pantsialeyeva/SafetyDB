package repository.impl;

import model.Criteria;
import repository.CriteriaRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import javax.xml.transform.Result;
import java.sql.*;

public class CriteriaRepositoryImpl implements CriteriaRepository {

    public Criteria setInDB (Criteria criteria) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_CRITERIAS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, criteria.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                criteria.setId(rs.getInt(1));
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("The criteria " + criteria + " already exists.");
            try {
                PreparedStatement ps = con.prepareStatement(SQLQuery.GET_CRITERIA_ID_BY_NAME);
                ps.setString(1, criteria.getName());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    criteria.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return criteria;
    }
}
