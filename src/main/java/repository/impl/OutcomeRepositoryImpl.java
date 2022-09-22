package repository.impl;

import model.Criteria;
import model.Outcome;
import repository.OutcomeRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class OutcomeRepositoryImpl implements OutcomeRepository {

    public OutcomeRepositoryImpl() {}

    public Outcome getByID(int id) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        Outcome newOutcome = null;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newOutcome = new Outcome(rs.getInt("id"), rs.getString("name"));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return newOutcome;
    }

    public Outcome getByName(String name) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        Outcome newOutcome = null;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newOutcome = new Outcome(rs.getInt("id"), rs.getString("name"));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return newOutcome;
    }

    public Outcome add(Outcome outcome) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_OUTCOMES, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, outcome.getName());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'authors'.");
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                outcome.setId(rs.getInt(1));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return outcome;
    }

    public int getId(String name) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        int id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_NAME);
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
