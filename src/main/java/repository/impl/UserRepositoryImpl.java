package repository.impl;

import model.User;
import repository.UserRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {

    private final DataSourceUtil pool;

    public UserRepositoryImpl() {
        pool = DataSourceUtil.create();
    }

    @Override
    public void update (User user) {
        Connection con = pool.getConnection();
        try(PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_IN_USERS)) {

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isActive());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }
    @Override
    public User getById(int id) {
        User user = new User();
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_USER_BY_USERID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("email"),
                            rs.getString("password"), rs.getBoolean("active"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user = null;
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_USER_BY_EMAIL)) {

            ps.setString(1, email);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("email"),
                            rs.getString("password"), rs.getBoolean("active"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return user;
    }

    @Override
    public User add(User user) {
//        try (Connection con = pool.getConnection();
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
    public int getId(User user) {
        int id = 0;
//        try (Connection con = pool.getConnection();
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

    @Override
    public User authorization(String email, String password) throws SQLException{
        // TODO: 10/1/2022 add implementation
        return null;
    }
}
