package repository.impl;

import model.Outcome;
import repository.OutcomeRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class OutcomeRepositoryImpl implements OutcomeRepository {

    public Outcome setInDB(Outcome outcome) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_OUTCOMES, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, outcome.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                outcome.setId(rs.getInt(1));
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("The outcome " + outcome + " already exists.");
            try {
                PreparedStatement ps = con.prepareStatement(SQLQuery.GET_OUTCOME_ID_BY_NAME);
                ps.setString(1, outcome.getName());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    outcome.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return outcome;
    }

}
