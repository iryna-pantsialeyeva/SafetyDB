package repository.impl;

import model.Reporter;
import repository.ReporterRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterRepositoryImpl implements ReporterRepository {

    public ReporterRepositoryImpl() {}

    public Reporter getByID(int id) {
        Reporter newReporter = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_ID);
             ResultSet rs = ps.executeQuery()){

            ps.setInt(1, id);
            if (rs.next()) {
                newReporter = new Reporter(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newReporter;
    }

    public Reporter getByName(String name) {
        Reporter newReporter = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
             ResultSet rs = ps.executeQuery()){

            ps.setString(1, name);
            if (rs.next()) {
                newReporter = new Reporter(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newReporter;
    }

    public Reporter add(Reporter reporter) {
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTERS, Statement.RETURN_GENERATED_KEYS);
             ResultSet rs = ps.getGeneratedKeys()){

            ps.setString(1, reporter.getFullName());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'authors'.");

            if (rs.next()) {
                reporter.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporter;
    }

    public int getId(String name) {
        int id = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
             ResultSet rs = ps.executeQuery()){

            ps.setString(1, name);
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
