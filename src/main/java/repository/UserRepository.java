package repository;

import model.User;

import java.sql.SQLException;

public interface UserRepository {

    User getById(int id);
    User getByEmail(String email);
}
