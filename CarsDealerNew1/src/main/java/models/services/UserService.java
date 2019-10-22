package models.services;

import models.entity.User;
import models.service.UserServiceModel;

public interface UserService {

    void register(String username, String email, String password, String confirmPassword) throws Exception;

    User getUserByName(String name);

    UserServiceModel login(String username, String password);
}
