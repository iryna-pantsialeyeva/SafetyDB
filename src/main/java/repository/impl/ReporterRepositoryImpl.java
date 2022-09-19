package repository.impl;

import model.Reporter;
import repository.ReporterRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterRepositoryImpl implements ReporterRepository {

    public Reporter setInDB (Reporter reporter) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTERS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, reporter.getFullName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                reporter.setId(rs.getInt(1));
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("The reporter " + reporter + " already exists.");
            try{
                PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_ID_BY_NAME);
                ps.setString(1, reporter.getFullName());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    reporter.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return reporter;
    }
}
