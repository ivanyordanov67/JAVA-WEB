package app.services;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    void save(UserServiceModel user);
    void update(UserServiceModel userServiceModel);
    UserServiceModel getById(String id);
    UserServiceModel findByUsernameAndPassword(String username, String password);
    List<UserServiceModel> getAll();
    void addFriend(UserServiceModel userServiceModel);
    String hashPassword(String password);
    void remove(String userId, String friendId);
}
