package com.softuni.vetpet.service.services.implementation;

import com.softuni.vetpet.data.models.User;
import com.softuni.vetpet.data.repositories.UserRepository;
import com.softuni.vetpet.service.models.LoginServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;
import com.softuni.vetpet.service.services.HashPasswordService;
import com.softuni.vetpet.service.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HashPasswordService hashPasswordService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, HashPasswordService hashPasswordService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.hashPasswordService = hashPasswordService;
    }

    @Override
    public void registerUser(UserServiceModel user) {

        this.userRepository.save(this.modelMapper.map(user, User.class));
    }

    @Override
    public boolean existUser(LoginServiceModel model) {
        String hashPassword = hashPasswordService.hashPassword(model.getPassword());
        return userRepository.existsUserByUsernameAndPassword(model.getUsername(), hashPassword);
    }

    @Override
    public UserServiceModel getUserByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findUserByUsername(username), UserServiceModel.class);
    }


}
