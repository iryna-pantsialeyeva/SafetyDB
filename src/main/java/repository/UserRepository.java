package repository;

import model.User;

import java.sql.SQLException;

public interface UserRepository {

    User getById(int id);
    User getByEmail(String email);
    User add(User user);
    int getId(User user);
    User authorization(String email, String password) throws SQLException;
}
