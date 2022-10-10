package service.impl;

import model.User;
import repository.impl.UserRepositoryImpl;
import service.ServiceException;
import service.UserService;
import repository.*;
import service.validation.UserValidator;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserValidator userValidator;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
        userValidator = new UserValidator();
    }
//
//    @Override
//    public User registration(String email, String password) {
//        User user = new User(email, password, true);
//        return user;
//    }
//
    @Override
    public User authorization(String email) throws ServiceException {
        if (!userValidator.isEmailValid(email)) {
            throw new ServiceException("Insert correct email.");
        }
        return userRepository.getByEmail(email);
    }

    @Override
    public int getId(User user) {
        return userRepository.getId(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }
}
