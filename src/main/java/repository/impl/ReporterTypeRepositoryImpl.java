package repository.impl;

import model.Criteria;
import model.Type;
import repository.ReporterTypeRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterTypeRepositoryImpl implements ReporterTypeRepository {

    public ReporterTypeRepositoryImpl() {}

    public Type getByID(int id) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        Type newType = null;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newType = new Type(rs.getInt("id"), rs.getString("name"));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return newType;
    }

    public Type getByName(String name) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        Type newType = null;
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newType = new Type(rs.getInt("id"), rs.getString("name"));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return newType;
    }

    public Type add(Type type) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTER_TYPES, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type.getName());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'authors'.");
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                type.setId(rs.getInt(1));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return type;
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
