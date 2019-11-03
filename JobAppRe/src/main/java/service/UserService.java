package service;

import domain.models.services.UserServiceModel;

public interface UserService {

    void register(UserServiceModel user);
    public String hashPassword(String password);
    UserServiceModel getByUsernameAndId(String username, String password);
}
