package repository.impl;

import model.Reporter;
import model.Type;
import repository.ReporterRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterRepositoryImpl implements ReporterRepository {

    public ReporterRepositoryImpl() {
    }

    @Override
    public Reporter getByID(int id) {
        Reporter newReporter = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_ID);
             ResultSet rs = ps.executeQuery();
             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_ID);
             ResultSet rs2 = ps2.executeQuery()) {

            ps.setInt(1, id);


            if (rs.next()) {
                ps2.setInt(1, rs.getInt("reporter_type_id"));
                Type type = new Type();
                if (rs2.next()) {
                    type.setId(rs2.getInt("id"));
                    type.setName.valueOf(rs2.getString("name"));
                }
                newReporter = new Reporter(rs.getInt("id"), rs.getString("full_name"),
                        type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newReporter;
    }

    @Override
    public Reporter getByName(String name) {
        Reporter newReporter = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, name);
            if (rs.next()) {
                newReporter = new Reporter(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newReporter;
    }

    @Override
    public Reporter add(Reporter reporter) {
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTERS, Statement.RETURN_GENERATED_KEYS);
             ResultSet rs = ps.getGeneratedKeys()) {

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

    @Override
    public int getId(String name) {
        int id = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
             ResultSet rs = ps.executeQuery()) {

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
