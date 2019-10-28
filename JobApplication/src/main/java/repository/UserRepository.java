package repository;

import domain.entities.User;

public interface UserRepository {

    void save(User user);
}
