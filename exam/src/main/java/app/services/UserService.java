package app.services;

import app.domain.models.service.UserServiceModel;

public interface UserService {

    void addUser(UserServiceModel user);
    public String hashPassword(String password);
    UserServiceModel getByUsernameAndPassword(String username, String password);
}
