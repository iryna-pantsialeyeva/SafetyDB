package repository.impl;

import model.Outcome;
import model.enums.CriteriaType;
import model.enums.OutcomeType;
import repository.OutcomeRepository;
import repository.util.ConnectionToDB;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class OutcomeRepositoryImpl implements OutcomeRepository {

    public OutcomeRepositoryImpl() {
    }

    @Override
    public Outcome getById(int id) {
        Outcome newOutcome = new Outcome();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_ID)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newOutcome.setId(rs.getInt("id"));
                    OutcomeType name = OutcomeType.valueOf(rs.getString("name"));
                    newOutcome.setName(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newOutcome;
    }

    @Override
    public Outcome getByName(String name) {
        Outcome newOutcome = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_NAME);
//             ResultSet rs = ps.executeQuery()){
//
//            ps.setString(1, name);
//            if (rs.next()) {
//                newOutcome = new Outcome(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return newOutcome;
    }

    @Override
    public Outcome add(Outcome outcome) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_OUTCOMES, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = ps.getGeneratedKeys()){
//
//            ps.setString(1, outcome.getName());
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'authors'.");
//
//            if (rs.next()) {
//                outcome.setId(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return outcome;
    }

    @Override
    public int getId(OutcomeType outcomeType) {
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_OUTCOMES_BY_NAME);
//             ResultSet rs = ps.executeQuery();){
//
//            ps.setString(1, name);
//            if (rs.next()) {
//                id = rs.getInt("id");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return id;
    }
}

