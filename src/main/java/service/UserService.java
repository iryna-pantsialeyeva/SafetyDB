package service;

import model.User;

public interface UserService {

//    User registration(String email, String password);

    User authorization(String email) throws ServiceException;

//    int getId(User user);

    User getById(int id);
}
