package repository.impl;

import model.Outcome;
import repository.OutcomeRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class OutcomeRepositoryImpl implements OutcomeRepository {

    public OutcomeRepositoryImpl() {
    }

    public Outcome getByID(int id) {
        Outcome newOutcome = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_ID);
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);
            if (rs.next()) {
                newOutcome = new Outcome(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newOutcome;
    }

    public Outcome getByName(String name) {
        Outcome newOutcome = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_NAME);
             ResultSet rs = ps.executeQuery()){

            ps.setString(1, name);
            if (rs.next()) {
                newOutcome = new Outcome(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newOutcome;
    }

    public Outcome add(Outcome outcome) {
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_OUTCOMES, Statement.RETURN_GENERATED_KEYS);
             ResultSet rs = ps.getGeneratedKeys()){

            ps.setString(1, outcome.getName());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'authors'.");

            if (rs.next()) {
                outcome.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outcome;
    }

    public int getId(String name) {
                int id = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_NAME);
             ResultSet rs = ps.executeQuery();){

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
