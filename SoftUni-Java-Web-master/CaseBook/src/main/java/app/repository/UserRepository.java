package app.repository;

import app.domain.entities.User;

public interface UserRepository {

    void save(User user);
}
