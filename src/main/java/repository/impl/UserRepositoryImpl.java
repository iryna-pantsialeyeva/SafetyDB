package repository.impl;

import model.Criteria;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository{

    public UserRepositoryImpl() {
    }

    @Override
    public User getByID(int id) {
        User newUser = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_USERS_BY_ID);
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);
            if (rs.next()) {
                newUser = new User(rs.getInt("id"), rs.getString("email"),
                        rs.getString("password"), rs.getBoolean("active"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }

    @Override
    public User getByEmail(String email) {
        User newUser = null;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_USERS_BY_NAME);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, email);
            if (rs.next()) {
                newUser = new User(rs.getInt("id"), rs.getString("email"),
                        rs.getString("password"), rs.getBoolean("active"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }

    @Override
    public User add(User user) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_USERS, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = ps.getGeneratedKeys()) {
//
//            ps.setString(1, user.getName());
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'authors'.");
//
//            if (rs.next()) {
//                user.setId(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return user;
    }

    @Override
    public int getId(String email) {
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_CRITERIAS_BY_NAME);
//             ResultSet rs = ps.executeQuery();) {
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
