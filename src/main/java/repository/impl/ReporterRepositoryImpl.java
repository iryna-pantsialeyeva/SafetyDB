package repository.impl;

import model.Outcome;
import model.Reporter;
import repository.ReporterRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterRepositoryImpl implements ReporterRepository {

    public ReporterRepositoryImpl() {}

    public Reporter getByID(int id) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        Reporter newReporter = null;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newReporter = new Reporter(rs.getInt("id"), rs.getString("name"));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return newReporter;
    }

    public Reporter getByName(String name) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        Reporter newReporter = null;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newReporter = new Reporter(rs.getInt("id"), rs.getString("name"));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return newReporter;
    }

    public Reporter add(Reporter reporter) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTERS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, reporter.getFullName());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'authors'.");
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                reporter.setId(rs.getInt(1));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return reporter;
    }

    public int getId(String name) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        int id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return id;
    }

    private static void closePS(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ignore) {
            }
        }
    }

    private static void closeRS(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ignore) {
            }
        }
    }
}
