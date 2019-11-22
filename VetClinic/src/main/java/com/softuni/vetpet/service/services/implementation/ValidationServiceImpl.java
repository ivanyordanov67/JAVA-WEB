package com.softuni.vetpet.service.services.implementation;

import com.softuni.vetpet.data.models.User;
import com.softuni.vetpet.service.models.LoginServiceModel;
import com.softuni.vetpet.service.models.UserServiceModel;
import com.softuni.vetpet.service.services.UserService;
import com.softuni.vetpet.service.services.ValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public ValidationServiceImpl(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isValid(String password, String confirmPassword) {
        return isConfirmPassword(password, confirmPassword);
    }

    private boolean isExistUser(String name) {
        return this.userService.isExistUserByUsername(name);
    }

    private boolean isConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isValidEmail(String email){

        String pattern = "^[A-Za-z0-9+_.-]+@(.+)$";

        return pattern.matches(email);
    }


}
