package com.softuni.vetpet.service.services;

import com.softuni.vetpet.data.models.User;
import com.softuni.vetpet.service.models.UserServiceModel;

public interface ValidationService {

    public boolean isValid(String password, String confirmPassword);
}
