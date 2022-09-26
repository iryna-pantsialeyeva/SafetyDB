package repository;

public interface UserRepository {

    User getByID(int id);
    User getByEmail(String email);
    User add(User user);
    int getId(String email);
}