package repository;

import domain.entities.User;

public interface UserRepository {

    void register(User user);
    User findByUsernameAndPassword(String username, String password);
}
