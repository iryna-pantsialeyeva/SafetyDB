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
    public User getById(int id) {
        User user = new User();
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_USER_BY_USERID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("email"),
                        rs.getString("password"), rs.getBoolean("active"));
            }
            rs.close();
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
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("email"),
                        rs.getString("password"), rs.getBoolean("active"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return user;
    }
}
