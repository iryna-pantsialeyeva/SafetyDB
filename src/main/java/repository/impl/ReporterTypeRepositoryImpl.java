package repository.impl;

import model.Type;
import repository.ReporterTypeRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterTypeRepositoryImpl implements ReporterTypeRepository {

    public Type setInDB (Type reporterType) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTER_TYPES, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, reporterType.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                reporterType.setId(rs.getInt(1));
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("The reporter's type " + reporterType + " already exists.");
            try {
                PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_TYPE_ID_BY_NAME);
                ps.setString(1, reporterType.getName());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    reporterType.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporterType;
    }
}
