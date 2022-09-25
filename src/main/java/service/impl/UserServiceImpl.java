package service.impl;

import model.Reporter;
import model.Type;
import model.User;
import model.enums.ReporterType;
import service.ReporterService;
import service.ServiceException;
import service.TypeService;
import service.UserService;
import repository.*;
import service.validation.UserValidator;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserValidator userValidator;
    ReporterService reporterService;
    TypeService typeService;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
        userValidator = new UserValidator();
        reporterService = new ReporterServiceImpl();
        typeService = new TypeServiceImpl();
    }

    public User registration(String email, String password, String fullName, ReporterType type) {
      typeService.save(type);
      int typeId = typeService.getId(type);
      Type typeToAdd = typeService.getByID(typeId);
      reporterService.add(fullName, typeToAdd);
      int id = reporterService.getId(fullName);
      Reporter reporterToAdd = reporterService.getByID(id);
      User user = new User(email, password, reporterToAdd, true);
      return user;
    }

    public User authorization(String email, String password) throws ServiceException {

        if (!userValidator.isEmailValid(email)) {
            throw new ServiceException("Insert correct email.");
        }
        User user;
        try {
            user = userRepository.authorization(email, password);
        } catch (SQLException e) {
            throw new ServiceException("There is no user with these email and password.", e);
        }
        return user;
    }

    public int getId(User user) {
        return userRepository.getId(user);
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }
}
