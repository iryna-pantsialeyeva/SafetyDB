package repository.impl;

import model.Type;
import repository.ReporterTypeRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterTypeRepositoryImpl implements ReporterTypeRepository {

    public ReporterTypeRepositoryImpl() {
    }

    public Type getByID(int id) {
        Type newType = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_ID);
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);
            if (rs.next()) {
                newType = new Type(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newType;
    }

    public Type getByName(String name) {
        Type newType = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_NAME);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, name);
            if (rs.next()) {
                newType = new Type(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newType;
    }

    public Type add(Type type) {
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTER_TYPES, Statement.RETURN_GENERATED_KEYS);
             ResultSet rs = ps.getGeneratedKeys()) {

            ps.setString(1, type.getName());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'authors'.");

            if (rs.next()) {
                type.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public int getId(String name) {
        int id = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_NAME);
             ResultSet rs = ps.executeQuery();) {

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
