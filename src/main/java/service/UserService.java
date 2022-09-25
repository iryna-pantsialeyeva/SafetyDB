package service;

import model.Reporter;
import model.User;
import model.enums.ReporterType;

public interface UserService {

    User registration(String email, String password, String fullName, ReporterType type);

    User authorization(String email, String password) throws ServiceException;

    int getId(User user);

    User getById(int id);
}
