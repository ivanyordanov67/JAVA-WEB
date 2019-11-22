package com.softuni.vetpet.service.services;

import com.softuni.vetpet.data.models.User;
import com.softuni.vetpet.service.models.LoginServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel user);
    //UserServiceModel getUserByUsernameAndPassword(UserServiceModel userServiceModel);
    boolean existUser(LoginServiceModel model);
    boolean isExistUserByUsername(String username);
    UserServiceModel getUserByUsername(String username);


}
