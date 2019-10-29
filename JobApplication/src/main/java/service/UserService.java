package service;

import domain.entities.User;
import domain.models.services.UserServiceModel;

public interface UserService {

    void save(UserServiceModel user);
    UserServiceModel findByUsernameAndPassword(String username, String password);
}
